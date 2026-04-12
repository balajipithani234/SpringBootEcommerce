package com.example.springboot.modal;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse 
{
	private Long paymentId;
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	private Long orderId;
	private Instant paymentDate;
	 private PaymentMode paymentMode;
	 private String paymentStatus;
	 private double amount;
	 
	 public Instant getPaymentDate() {
		return paymentDate;
	}
	 public void setPaymentDate(Instant paymentDate) {
		 this.paymentDate = paymentDate;
	 }
	 public String getPaymentStatus() {
		 return paymentStatus;
	 }
	 public void setPaymentStatus(String paymentStatus) {
		 this.paymentStatus = paymentStatus;
	 }
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
