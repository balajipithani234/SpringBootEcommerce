package com.example.springboot.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest 
{
 private Long orderId;
 private PaymentMode paymentMode;
 private double amount;
 public Long getOrderId() {
	return orderId;
 }
 public void setOrderId(Long orderId) {
	 this.orderId = orderId;
 }
 public PaymentMode getPaymentMode() {
	return paymentMode;
 }
 public void setPaymentMode(PaymentMode paymentMode) {
	this.paymentMode = paymentMode;
 }
 public double getAmount() {
	return amount;
 }
 public void setAmount(double amount) {
	this.amount = amount;
 }
 
 
}
