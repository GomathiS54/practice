package com.example.Ecommerce.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.Ecommerce.dto.PaymentDto;
import com.example.Ecommerce.repo.PaymentRepo;

@Repository
public class PaymentDao {

	
	
	
	    @Autowired
	    private PaymentRepo prepo;
	    
	    
	    
	    public PaymentDto savePayment(PaymentDto payment) {
	        return prepo.save(payment);
	    }

	    
	    public List<PaymentDto> getAllPayments() {
	        return prepo.findAll();
	    }

	    public PaymentDto getbyId(int id) {
	    	java.util.Optional<PaymentDto>o=prepo.findById(id);
	    	return o.orElse(null);
	    }
	  
	   

}
