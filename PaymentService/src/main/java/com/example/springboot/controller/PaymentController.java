package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.modal.PaymentRequest;
import com.example.springboot.modal.PaymentResponse;
import com.example.springboot.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController 
{
 @Autowired
 private PaymentService paymentService;
 
 @PostMapping("/doPayment")
 public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest)
 {
	 Long orderId=paymentService.doPayment(paymentRequest);
	 return new ResponseEntity<>(orderId,HttpStatus.OK);
 }
 @GetMapping("/{orderId}")
 public ResponseEntity<PaymentResponse>getPaymentDetails(@PathVariable ("orderId")Long orderId)
 {
	 PaymentResponse paymentResponse=paymentService.getPaymentDetails(orderId); 
      return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
 }
}
