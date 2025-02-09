package com.example.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Repo.ItJobs;


@RestController
@RequestMapping("/jobs")
public class ItJobsCon {

	private final ItJobs itJobs;
	//@Qualifier("developDept")
	//@Autowired
	//public ItJobs itJobs;
	
	@Autowired
	public  ItJobsCon(@Qualifier("developDept") ItJobs itJobs) {
		this.itJobs=itJobs;
	}
	
	 @GetMapping
	 public String Depts() {
		 return itJobs.Depts();
	 }

	
}
