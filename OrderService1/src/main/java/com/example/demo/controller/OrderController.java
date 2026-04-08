package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.OrderRequest;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
 @PostMapping("/add")
 public ResponseEntity<Long>addOrder(@RequestBody OrderRequest orderReq)
 {
	Long orderId =orderService.addOrder(orderReq);
	return new ResponseEntity<>(orderId,HttpStatus.OK);
 }
}
