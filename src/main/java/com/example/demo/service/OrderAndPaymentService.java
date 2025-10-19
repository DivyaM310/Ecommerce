package com.example.demo.service;

import com.example.demo.dto.OrderAndPaymentDto;

public interface OrderAndPaymentService {

	public void saveOrderAndPayment(OrderAndPaymentDto dto);
	public void saveFeedbackAndCashback(OrderAndPaymentDto dto);
}
