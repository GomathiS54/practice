package com.example.test.Dto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class Jobs implements CommandLineRunner {

	
	@Override
	public void run(String args[])throws Exception{
		System.out.println("Welcome to Archimedis Digital");
		}
}
