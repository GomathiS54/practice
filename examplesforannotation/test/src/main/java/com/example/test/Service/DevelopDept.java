package com.example.test.Service;

import org.springframework.stereotype.Service;

import com.example.test.Repo.ItJobs;

@Service
public class DevelopDept implements ItJobs{

	@Override
	public String Depts() {
		return "Application developed Process!!";
	}
	
	
}
