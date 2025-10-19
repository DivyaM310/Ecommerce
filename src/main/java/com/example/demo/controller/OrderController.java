package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderAndPaymentDto;
import com.example.demo.service.OrderAndPaymentService;


@RestController
public class OrderController {

	@Autowired
	OrderAndPaymentService service;
	@PostMapping("order-payment")
	
	public String saveOrderAndPaymemt(@RequestBody OrderAndPaymentDto dto) {
		service.saveOrderAndPayment(dto);
		service.saveFeedbackAndCashback(dto);
		return "Order Placed";
	}
	
}
