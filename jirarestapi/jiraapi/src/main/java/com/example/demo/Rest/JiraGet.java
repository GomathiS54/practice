package com.example.demo.Rest;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JiraGet {
		
	       @GetMapping("get")
		   public ResponseEntity<String> createJiraIssue(String accessToken) {
			String url = "https://archimedis-team-ms94t67m.atlassian.net/rest/api/2/issue/SCRUM";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String auth = "gomathi@archimedis.io" + ":" + accessToken;
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

		    headers.set("Authorization", "Basic " + encodedAuth);

			HttpEntity<String> entity = new HttpEntity<>(headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

			System.out.println(response.getBody());
			return response;
		}

		public static void main(String[] args) {
			JiraGet jiraget = new JiraGet();
			jiraget.createJiraIssue(
					"ATATT3xFfGF0lxEa97stqULzRGKeSXGxmc10JSLhIwkf9UimtaK9O0lLMTKaIZ94KrPp2379NFYKkYncvT_X4ZcIyvcNdxBThAcdEfMEeVsuKHtzX6IupTR2NwGUmDoxa0K6OP3SuoasQzQr2ZQn4YI8lqEDSU_EZtnOFIDBwMQeSaiRtE9UAEA=5BA80FDA");
		}
	
}
