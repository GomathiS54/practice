package com.example.Ecommerce.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Ecommerce.dto.OrderDto;

public interface OrderRepo extends JpaRepository<OrderDto, Integer>{
	
	
	List<OrderDto> findByOrdDateAfterOrderByOrdDateDesc(LocalDate startDate);
	
	@Query("SELECT o FROM OrderDto o WHERE o.ordDate BETWEEN :startDate AND :endDate")
    List<OrderDto> findOrdersByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}


    
   

