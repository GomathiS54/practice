package com.example.Ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.dto.CustomerDto;

public interface CustomerRepo extends JpaRepository<CustomerDto, Integer> {

}
