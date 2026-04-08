package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import com.example.demo.modal.ErrorResponse;

@RestControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler
{
 @ExceptionHandler(OrderServiceCustomException.class)
 public ResponseEntity<ErrorResponse>productServiceExceptionHandel(OrderServiceCustomException exception)
 {
	ErrorResponse response=new ErrorResponse();
	 response.setMessage(exception.getMessage());
	 response.setErrorCode(exception.getErrorCode());
	 return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
 }
}
