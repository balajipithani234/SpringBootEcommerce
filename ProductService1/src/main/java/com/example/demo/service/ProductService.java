package com.example.demo.service;

import com.example.demo.exception.ProductServiceException;
import com.example.demo.modal.ProductRequest;
import com.example.demo.modal.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productReq);

	ProductResponse getProductById(Long productId)throws ProductServiceException ;

	void reduceQuantity(Long productId, int quantity)throws ProductServiceException ;

	
}
