package com.example.springboot.entity;

import java.time.Instant;

import com.example.springboot.modal.PaymentMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Table_paymentdetails")
public class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	@Column(name="order_id")
	private Long orderId;
	private Instant paymentDate;
	 private String paymentMode;
	 private String paymentStatus;
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
	 private double amount;
	 
	 
	 public Long getPaymentId() {
		return paymentId;
	}
	 public void setPaymentId(Long paymentId) {
		 this.paymentId = paymentId;
	 }
	 public Long getOrderId() {
		 return orderId;
	 }
	 public void setOrderId(Long orderId) {
		 this.orderId = orderId;
	 }
	 public String getPaymentMode() {
		 return paymentMode;
	 }
	 public void setPaymentMode(String string) {
		 this.paymentMode = string;
	 }
	 public double getAmount() {
		 return amount;
	 }
	 public void setAmount(double amount) {
		 this.amount = amount;
	 }
	 
	 
}
