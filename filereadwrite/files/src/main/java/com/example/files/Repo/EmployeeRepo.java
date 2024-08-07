package com.example.files.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.files.Dto.EmployeeDto;

public interface EmployeeRepo extends JpaRepository<EmployeeDto, Long>  {
	

}
