package com.example.Ecommerce.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private int cusId;

	@Column(name = "cus_name")
	private String cusName;

	@Column(name = "cus_phone")
	private String cusPhone;

	@Column(name = "cus_add")
	private String cusAdd;

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusAdd() {
		return cusAdd;
	}

	public void setCusAdd(String cusAdd) {
		this.cusAdd = cusAdd;
	}

	@Override
	public String toString() {
		return "CustomerDto[cusId=" + cusId + ",cusName=" + cusName + " ,cusPhone=" + cusPhone + ", cusAdd=" + cusAdd
				+ "]";
	}
}
