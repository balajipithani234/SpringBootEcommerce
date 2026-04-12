package com.example.springboot.service;

import com.example.springboot.modal.PaymentRequest;
import com.example.springboot.modal.PaymentResponse;

public interface PaymentService {

	Long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetails(Long orderId);

}
