package com.example.files.Dto;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JacksonXmlRootElement(localName = "employee")
public class EmployeeDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(localName="empId")
	private long empId;
	
	@JacksonXmlProperty(localName="empName")
	private String empName;
	
	@JacksonXmlProperty(localName = "empSal")
	private int empSal;
	
	@JacksonXmlProperty(localName = "empDept")
	private String empDept;
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	

}
