package com.example.test.Service;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.test.Repo.ItJobs;

//@Primary
@Service
public class TestingDept implements ItJobs {
    
	@Override
	public String Depts() {
		return "Application to praper Testing!!";
	}
}
