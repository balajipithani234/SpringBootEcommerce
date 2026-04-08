package com.example.demo.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.ProductService;
import com.example.demo.entity.Order;
import com.example.demo.modal.OrderRequest;
import com.example.demo.repository.OrderRepository;

//import jdk.jpackage.internal.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService 
{
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
 @Autowired
 private OrderRepository repo;
 @Autowired
 private ProductService productService;
	@Override
	public Long addOrder(OrderRequest orderReq) 
	{
		// TODO Auto-generated method stub
		log.info("Before placing order");
		productService.reduceQuantity(orderReq.getProductId(),orderReq.getQuantity());
		log.info("After checking product availability for product "+orderReq.getProductId());
		 Order order=new Order();
		    order.setProductId(orderReq.getProductId());
		    order.setPrice(orderReq.getPrice());
		    order.setOrderDate(Instant.now());
		    order.setOrderStatus("CREATED");
		    order.setQuantity(orderReq.getQuantity());
		    
		    log.info("order placed");
		    repo.save(order);
		    log.info("product saved sucessfully after placed order");
		return order.getOrderId();
	}

}
