package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.OrderAndPaymentDto;
import com.example.demo.entity.Cashback;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Order;
import com.example.demo.entity.Payment;
import com.example.demo.repository.CashbackRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;


@Service
public class OrderAndPaymentServiceImpl implements OrderAndPaymentService {

	@Autowired
	OrderRepository oRepository;
	@Autowired
	PaymentRepository pRepository;
	@Autowired
	CashbackRepository cRepository;
	@Autowired
	FeedbackRepository fRepository;

	@Transactional
	public void saveFeedbackAndCashback(OrderAndPaymentDto dto) {
		Feedback feedback = new Feedback();
		feedback.setMessage(dto.getMessage());
		feedback.setRating(dto.getRating());

		Cashback cashback = new Cashback();
		cashback.setPoints(dto.getRating() * 4);

		fRepository.save(feedback);
		System.out.println(10 / 0);
		cRepository.save(cashback);
	}

	@Override
	@Transactional
	public void saveOrderAndPayment(OrderAndPaymentDto dto) {
		Order order = new Order();
		order.setOrderName(dto.getOrderName());
		order.setPrice(dto.getPrice());
		order.setQuantity(dto.getQuantity());

		Payment payment = new Payment();
		payment.setPaymentMode(dto.getPaymentMode());
		payment.setAmount(dto.getPrice() * dto.getQuantity());

		oRepository.save(order);
		pRepository.save(payment);
	}

}
