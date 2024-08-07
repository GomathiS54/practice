package com.example.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.dao.PaymentDao;
import com.example.Ecommerce.dto.PaymentDto;

@RestController
@RequestMapping("api/payments")
public class PaymentCon {

	
	
	
	@Autowired
    private PaymentDao pdao;
    
    
    
    @PostMapping("saveall")
	public PaymentDto paymentdetails(@RequestBody PaymentDto payment) {
		return pdao.savePayment(payment);
	}

	@GetMapping("get")
	public List<PaymentDto> getAllPaymentsdetails() {
		return pdao.getAllPayments();
	}

	@GetMapping("getbyid")
	public PaymentDto getById(@RequestParam int id) {
	
		return pdao.getbyId(id);
      }
}
