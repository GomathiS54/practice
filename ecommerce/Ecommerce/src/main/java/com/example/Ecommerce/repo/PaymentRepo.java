package com.example.Ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.dto.PaymentDto;

public interface PaymentRepo extends JpaRepository<PaymentDto, Integer> {

}
