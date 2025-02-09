package com.example.files.Service;

import java.io.File;
import java.io.IOException;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.files.Dto.EmployeeDto;
import com.example.files.Repo.EmployeeRepo;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service 
public class EmployeeService {
        
	    private final EmployeeRepo employeeRepo;
	    private final XmlMapper xmlMapper ;
	    
	    
        
	   public EmployeeService(EmployeeRepo employeeRepo, XmlMapper xmlMapper) {
		   this.employeeRepo=employeeRepo;
		   this.xmlMapper=xmlMapper;
		   
	   }
	    
	    public void saveToFile(List<EmployeeDto> employees, String filePath) throws IOException {
	        xmlMapper.writeValue(new File(filePath), employees);
	    }

	    public List<EmployeeDto> readFromFile(String filePath) throws IOException {
	        return xmlMapper.readValue(new File(filePath), xmlMapper.getTypeFactory().constructCollectionType(List.class, EmployeeDto.class));
	    }

	    
	 
	}


