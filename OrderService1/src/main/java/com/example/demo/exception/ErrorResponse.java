package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse 
{
	 private String message;
	  private String errorCode;
	  public String getMessage() {
		  return message;
	  }
	  public void setMessage(String message) {
		  this.message = message;
	  }
	  public String getErrorCode() {
		  return errorCode;
	  }
	  public void setErrorCode(String errorCode) {
		  this.errorCode = errorCode;
	  }
}
