package com.example.Ecommerce.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.dto.CustomerDto;
import com.example.Ecommerce.repo.CustomerRepo;

@Repository
public class CustomerDao {


	    @Autowired
	    private CustomerRepo repo;
	    
	    
	    public CustomerDto saveCustomer(CustomerDto customer) {
	        return repo.save(customer);
	    }


	    public List<CustomerDto> getAllCustomers() {
	        return repo.findAll();
	    }
        
	    
	    public CustomerDto getbyId(int id) {
	    	java.util.Optional<CustomerDto>o=repo.findById(id);
	    	return o.orElse(null);
	    }
	    
	   
	    

}
