package com.example.springboot.service;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.service.OrderServiceImpl;
import com.example.springboot.entity.Payment;
import com.example.springboot.modal.PaymentMode;
import com.example.springboot.modal.PaymentRequest;
import com.example.springboot.modal.PaymentResponse;
import com.example.springboot.repository.PaymentRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService 
{
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
  private PaymentRepository repo;
	@Override
	public Long doPayment(PaymentRequest paymentRequest) 
	{
		// TODO Auto-generated method stub
		log.info("Payment request in payment service impl :"+paymentRequest);
		Payment pay=new Payment();
		pay.setOrderId(paymentRequest.getOrderId());
		pay.setPaymentDate(Instant.now());
		pay.setPaymentMode(paymentRequest.getPaymentMode().name());
		pay.setPaymentStatus("SUCESS");
		pay.setAmount(paymentRequest.getAmount());
		
		log.info("payment details save in doPayment :"+pay);
		repo.save(pay);
		return pay.getOrderId();
	}
	@Override
	public PaymentResponse getPaymentDetails(Long orderId) {
		// TODO Auto-generated method stub
		Payment pay=repo.findByOrderId(orderId)
				     .orElseThrow(()-> new RuntimeException("ORDER_ID_NOT_FOUND "+orderId));
		
		PaymentResponse payResponse=new PaymentResponse();
		payResponse.setOrderId(pay.getOrderId());
		payResponse.setPaymentId(pay.getPaymentId());
		payResponse.setPaymentDate(pay.getPaymentDate());
		payResponse.setPaymentMode(PaymentMode.valueOf(pay.getPaymentMode().toUpperCase()));
		payResponse.setPaymentStatus(pay.getPaymentStatus());
		payResponse.setAmount(pay.getAmount());
		return payResponse;
	}

}
