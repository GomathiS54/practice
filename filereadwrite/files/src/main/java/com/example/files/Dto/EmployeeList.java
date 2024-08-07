package com.example.files.Dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employee")
public class EmployeeList {
	 
	 @JacksonXmlElementWrapper(useWrapping = false)
     private List<EmployeeDto>employee;
    
	  public List<EmployeeDto> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeDto> employee) {
		this.employee = employee;
	}

	
	
	
	
}
