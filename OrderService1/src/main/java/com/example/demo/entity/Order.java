package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	 private Long productId;
	 private double price;
	 private Instant orderDate;
	 private String orderStatus;
	 private int quantity;
	 public Long getOrderId() {
		 return orderId;
	 }
	 public void setOrderId(Long orderId) {
		 this.orderId = orderId;
	 }
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
	 public Instant getOrderDate() {
		 return orderDate;
	 }
	 public void setOrderDate(Instant orderDate) {
		 this.orderDate = orderDate;
	 }
	 public String getOrderStatus() {
		 return orderStatus;
	 }
	 public void setOrderStatus(String orderStatus) {
		 this.orderStatus = orderStatus;
	 }
	 public int getQuantity() {
		 return quantity;
	 }
	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
	 }
	 
	 
}
