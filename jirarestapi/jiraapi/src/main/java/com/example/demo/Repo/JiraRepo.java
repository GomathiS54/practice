package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Dto.JiraDto;
@Repository
public interface JiraRepo extends JpaRepository<JiraDto, Long> {
	
	 
	 JiraDto findByIssueId(long issueId);
}
