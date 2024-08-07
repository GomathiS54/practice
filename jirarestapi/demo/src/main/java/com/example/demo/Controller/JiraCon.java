package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.JiraDto;
import com.example.demo.Service.JiraService;

@RestController
@RequestMapping("/api/jira")
public class JiraCon{

    private final JiraService jiraService;

    public JiraCon(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    @GetMapping("/issues")
    public List<JiraDto> getAllJiraIssues() {
        return jiraService.getIssues();
    }
    
   
}



  

