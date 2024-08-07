package com.example.Ecommerce.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.dao.CustomerDao;
import com.example.Ecommerce.dto.CustomerDto;


@RestController
@RequestMapping("api/customers")
public class CustomeCon {

	    @Autowired
	    private CustomerDao dao;
	    
	    
	    
	    @PostMapping("save")
		public CustomerDto saveCustomerdetails(@RequestBody CustomerDto customer) {
			return dao.saveCustomer(customer);
		}

		@GetMapping("add")
		public List<CustomerDto> getAllCustomersdetails() {
			return dao.getAllCustomers();
		}

		@GetMapping("addbyid")
		public CustomerDto getById(@RequestParam int id) {
			return dao.getbyId(id);
	   
		}
}
