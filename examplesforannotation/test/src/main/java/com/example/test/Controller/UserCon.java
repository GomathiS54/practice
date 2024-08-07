package com.example.test.Controller;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Dto.UserDto;



@RestController
@RequestMapping("/user")
public class UserCon {

	
	
	@GetMapping("/get")
	public UserDto user() {
		return new UserDto(143,"gomathi","arumbavur","8925679185","perambalur");
	}

}
