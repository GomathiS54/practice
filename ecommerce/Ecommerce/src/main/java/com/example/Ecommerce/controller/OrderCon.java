package com.example.Ecommerce.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.dao.OrderDao;

import com.example.Ecommerce.dto.OrderDto;



@RestController
@RequestMapping("api/orders")
public class OrderCon {
	
	
	
	@Autowired
    private OrderDao odao;
    
    
    
    @PostMapping("create")
	public OrderDto saveOrderdetails(@RequestBody OrderDto orderdto) {
		return odao.saveOrder(orderdto);
	}

	@GetMapping("add")
	public List<OrderDto> getAllOrdersdetails() {
		return odao.getAllOrders();
	}

	@GetMapping("addbyid")
	public OrderDto getById(@RequestParam int id) {
		return odao.getbyId(id);
	}
	
	 @GetMapping("totalorders")
	    public List<OrderDto> getOrdersByTimePeriod(@RequestParam("timePeriod") String timePeriod) {
	        return odao.findOrdersByTimePeriod(timePeriod);
	    }
	
	
	 @GetMapping("date")
	    public List<OrderDto> getOrdersByDateRange(
	            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
	        return odao.findOrdersByDateRange(startDate, endDate);
	    }

	
	
	    
	    
	    
	    
}
