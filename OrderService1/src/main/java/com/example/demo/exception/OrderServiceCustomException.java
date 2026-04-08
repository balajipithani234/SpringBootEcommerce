package com.example.demo.exception;

import lombok.Data;

@Data
public class OrderServiceCustomException extends Exception
{
 private String errorCode;
 public OrderServiceCustomException(String message,String errorCode)
 {
	 super(message);
	 this.errorCode=errorCode;
 }
 public String getErrorCode() {
	return errorCode;
 }
 public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
 }
}
