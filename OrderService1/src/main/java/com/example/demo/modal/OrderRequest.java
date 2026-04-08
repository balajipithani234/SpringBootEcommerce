package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest 
{
	private Long productId;
	 private double price;
	 private PaymentMode paymentMode;
	 public Long getProductId() {
		return productId;
	}
	 public void setProductId(Long productId) {
		 this.productId = productId;
	 }
	 public double getPrice() {
		 return price;
	 }
	 public void setPrice(double price) {
		 this.price = price;
	 }
	 public PaymentMode getPaymentMode() {
		 return paymentMode;
	 }
	 public void setPaymentMode(PaymentMode paymentMode) {
		 this.paymentMode = paymentMode;
	 }
	 public int getQuantity() {
		 return quantity;
	 }
	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
	 }
	 private int quantity;
}
