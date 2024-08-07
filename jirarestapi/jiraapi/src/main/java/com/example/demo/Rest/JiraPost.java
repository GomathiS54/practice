package com.example.demo.Rest;

import java.util.Base64;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JiraPost {
			@PostMapping("/add")
	        public ResponseEntity<String> createJiraIssue(String accessToken) {
	        String url = "https://archimedis-team-ms94t67m.atlassian.net/rest/api/2/issue";

	        String jsonBody = "{ \"fields\": { " +
	                         "\"project\": { \"key\": \"SCRUM\" }, " +
	                        "\"summary\": \"Customer Issue\", " +
	                         "\"description\": \"Create to Customer \", " +
	                          "\"issuetype\": { \"name\": \"Bug\" } " +
	                         "} }";

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        String auth = "gomathi@archimedis.io" + ":" + accessToken;
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
			
	        headers.set("Authorization", "Basic " + encodedAuth);

	        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

	        System.out.println(response.getBody());
	        return response;
	    }

	    public static void main(String[] args) {
	        JiraPost jiraPost = new JiraPost();
	        jiraPost.createJiraIssue(
	        		"ATATT3xFfGF0lxEa97stqULzRGKeSXGxmc10JSLhIwkf9UimtaK9O0lLMTKaIZ94KrPp2379NFYKkYncvT_X4ZcIyvcNdxBThAcdEfMEeVsuKHtzX6IupTR2NwGUmDoxa0K6OP3SuoasQzQr2ZQn4YI8lqEDSU_EZtnOFIDBwMQeSaiRtE9UAEA=5BA80FDA");
	    }
	    
	    
	    
	    
	    
	}

