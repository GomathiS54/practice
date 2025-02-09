package com.example.files.Controller;

import com.example.files.Dto.EmployeeDto;

import com.example.files.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeCon {

	    private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeCon(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @PostMapping("/write")
	    public ResponseEntity<String> writeEmployeeFile(@RequestParam String filePath, @RequestBody List<EmployeeDto> employees) {
	        try {
	            employeeService.saveToFile(employees, filePath);
	            return new ResponseEntity<>("Employees saved successfully!", HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>("Failed to save employees: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/read")
	    public ResponseEntity<List<EmployeeDto>> readEmployeesFromFile(@RequestParam String filePath) {
	        try {
	            List<EmployeeDto> employees = employeeService.readFromFile(filePath);
	            return new ResponseEntity<>(employees, HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	}
