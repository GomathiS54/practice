package com.example.demo.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Dto.JiraDto;
import com.example.demo.Dto.JiraResponse;
import com.example.demo.Repo.JiraRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JiraService {

	@Value("${jira.url}")
	private String jiraUrl;

	@Value("${jira.username}")
	private String username;

	@Value("${jira.token}")
	private String token;

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	private final JiraRepo jiraRepo;

	public JiraService(RestTemplate restTemplate, ObjectMapper objectMapper, JiraRepo jiraRepo) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
		this.jiraRepo = jiraRepo;
	}

	public List<JiraDto> getAllJiraIssues(String jsonResponse) {
		List<JiraDto> jiraIssues = new ArrayList<>();
		try {
			JiraResponse jiraResponse = objectMapper.readValue(jsonResponse, JiraResponse.class);

			for (JiraResponse.Issue issue : jiraResponse.getIssues()) {
				JiraDto jiraDto = mapToJiraDto(issue);
				System.out.println(jiraDto.getId());
				System.out.println(jiraRepo.findByIssueId(jiraDto.getIssueId()));
				if (null == jiraRepo.findByIssueId(jiraDto.getIssueId())) {
					jiraRepo.save(jiraDto);
				}
				jiraIssues.add(jiraDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jiraRepo.findAll();
	}

	public List<JiraDto> getIssues() {
		String url = jiraUrl + "/rest/api/2/search?jql=project=SCRUM";

		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("gomathi@archimedis.io",
				"ATATT3xFfGF0lxEa97stqULzRGKeSXGxmc10JSLhIwkf9UimtaK9O0lLMTKaIZ94KrPp2379NFYKkYncvT_X4ZcIyvcNdxBThAcdEfMEeVsuKHtzX6IupTR2NwGUmDoxa0K6OP3SuoasQzQr2ZQn4YI8lqEDSU_EZtnOFIDBwMQeSaiRtE9UAEA=5BA80FDA");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		return getAllJiraIssues(response.getBody());
	}

	private JiraDto mapToJiraDto(JiraResponse.Issue issue) {
		JiraDto jiraDto = new JiraDto();
		jiraDto.setIssueId(issue.getId());
		jiraDto.setProjectKey(issue.getKey());
		jiraDto.setSummary(issue.getFields().getSummary());
		jiraDto.setDescription(issue.getFields().getDescription());

		jiraDto.setCreator(issue.getFields().getCreator().getDisplayName());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String createdDateStr = issue.getFields().getCreated();

		LocalDateTime createdDate = LocalDateTime.parse(createdDateStr, formatter);
		jiraDto.setCreationTime(createdDate);

		return jiraDto;
	}
}
