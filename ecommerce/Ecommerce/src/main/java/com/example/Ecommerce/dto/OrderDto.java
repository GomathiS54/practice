package com.example.Ecommerce.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class OrderDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_id")
	private int ordId;

	@Column(name = "ord_date")
	private LocalDate ordDate;

	@Column(name = "ord_time")
	private LocalTime ordTime;

	@Column(name = "ord_quantity")
	private int ordQuantity;

	@Column(name = "ord_quality")
	private int ordQuality;

	@Column(name = "ord_type")
	private String ordType;

	@Column(name = "ord_price")
	private int ordPrice;

	@ManyToOne
	@JoinColumn(name = "cus_id", nullable = false)
	private CustomerDto customerDto;


	@ManyToOne
    @JoinColumn(name = "pay_id",nullable=false)
    private PaymentDto paymentDto;
	
    
    public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public LocalDate getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}

	public LocalTime getOrdTime() {
		return ordTime;
	}

	public void setOrdTime(LocalTime ordTime) {
		this.ordTime = ordTime;
	}

	public int getOrdQuantity() {
		return ordQuantity;
	}

	public void setOrdQuantity(int ordQuantity) {
		this.ordQuantity = ordQuantity;
	}

	public int getOrdQuality() {
		return ordQuality;
	}

	public void setOrdQuality(int ordQuality) {
		this.ordQuality = ordQuality;
	}

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public int getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public PaymentDto getPaymentDto() {
		return paymentDto;
	}

	public void setPaymentDto(PaymentDto paymentDto) {
		this.paymentDto = paymentDto;
	}

	@Override
	public String toString() {
		return "OrderDto[ordId=" + ordId + ",ordDate=" + ordDate + ",ordTime=" + ordTime + ",ordQuantity=" + ordQuantity
				+ ",ordQuality=" + ordQuality + ",ordPrice=" + ordPrice + ",customerDto=" + customerDto + ",paymentDto="
				+ paymentDto + "]";
	}

}
