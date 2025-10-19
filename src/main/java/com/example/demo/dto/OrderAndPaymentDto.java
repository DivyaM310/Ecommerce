package com.example.demo.dto;

import lombok.Data;

@Data
public class OrderAndPaymentDto {
	
	private String orderName;
	private int price;
	private int quantity;
	private String paymentMode;
	private String message;
	private int rating;
	
}
