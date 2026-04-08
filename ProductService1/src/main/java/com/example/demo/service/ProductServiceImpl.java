package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductServiceException;
import com.example.demo.modal.ProductRequest;
import com.example.demo.modal.ProductResponse;
import com.example.demo.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService 
{
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
 @Autowired
 private ProductRepository productRepo;
 
	@Override
	public Long addProduct(ProductRequest productReq) {
		// TODO Auto-generated method stub
		Product product=new Product();
		   product.setProductName(productReq.getProductName());
		   product.setPrice(productReq.getPrice());
		   product.setQuantity(productReq.getQuantity());
		   
		   productRepo.save(product);
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(Long productId) throws ProductServiceException {
		// TODO Auto-generated method stub             // .get();
		Product product=productRepo.findById(productId)
				         .orElseThrow(()->new ProductServiceException("PRODUCT_ID_NOTFOUND","PRODUCT_IS_NOTFOUND"));
		ProductResponse response=new ProductResponse();
		  response.setProductName(product.getProductName());
		  response.setPrice(product.getPrice());
		  response.setQuantity(product.getQuantity());
		  
		return response;
	}

	@Override
	public void reduceQuantity(Long productId, int quantity) throws ProductServiceException 
	{
		log.info("reducing quantity intiated");
		Product product=productRepo.findById(productId)
				.orElseThrow(()-> new ProductServiceException("PRODUCT_ID_NOTFOUND","product Is not found"));
		if(product instanceof Product)
		{
			log.info("checking product quantity");
			if(product.getQuantity() < quantity)
			{
				throw new ProductServiceException("NOT_ENOUGH_QUANTITY","PRODUCT_ID_INVALID");
			}
		}
		product.setQuantity(product.getQuantity()-quantity);
		productRepo.save(product);
		
	}

}
