package com.example.demo.entity;

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
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private Long productId;
 private String productName;
 private double price;
 private int quantity;
 public Long getProductId() {
	return productId;
 }
 public void setProductId(Long productId) {
	this.productId = productId;
 }
 public String getProductName() {
	return productName;
 }
 public void setProductName(String productName) {
	this.productName = productName;
 }
 public double getPrice() {
	return price;
 }
 public void setPrice(double price) {
	this.price = price;
 }
 public int getQuantity() {
	return quantity;
 }
 public void setQuantity(int quantity) {
	this.quantity = quantity;
 }
 
 
}
