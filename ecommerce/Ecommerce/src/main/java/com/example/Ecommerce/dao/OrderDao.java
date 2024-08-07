package com.example.Ecommerce.dao;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.example.Ecommerce.dto.OrderDto;
import com.example.Ecommerce.repo.OrderRepo;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepo orepo;

	public OrderDto saveOrder(OrderDto orderDto) {
		return orepo.save(orderDto);
	}

	public List<OrderDto> getAllOrders() {
		return orepo.findAll();
	}

	  public OrderDto getbyId(int id) {
	    	java.util.Optional<OrderDto>o=orepo.findById(id);
	    	return o.orElse(null);
	    }
	  
	  
	  public List<OrderDto> findOrdersByTimePeriod(String timePeriod) {
	        LocalDate startDate = determineStartDate(timePeriod);
	        return orepo.findByOrdDateAfterOrderByOrdDateDesc(startDate);
	    }

	    private LocalDate determineStartDate(String timePeriod) {
	        LocalDate startDate = null;
	        
	        switch (timePeriod) {
	            case "1year":
	                startDate = LocalDate.now().minusYears(1);
	                break;
	            
	            case "6months":
	                startDate = LocalDate.now().minusMonths(6);
	                break;
	            
	            case "3months":
	                startDate = LocalDate.now().minusMonths(3);
	                break;
	                
	            
	            case "1week":
	            	startDate =LocalDate.now().minusWeeks(1);
	            	break;
	            
	            case "15days":
	            	startDate =LocalDate.now().minusDays(15);
	            	break;
	            
	            case "1day":
	            	startDate =LocalDate.now().minusDays(1);
	            	break;
	           default:
	                throw new IllegalArgumentException("Invalid time period: " + timePeriod);
	        }
	        
	        return startDate;
	    }
	    
	    
	    public List<OrderDto> findOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
	        return orepo.findOrdersByDateRange(startDate, endDate);
	    }

	    
	    
}