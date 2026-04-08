package com.example.demo.exception.dcoder;

import java.io.IOException;

import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.OrderServiceCustomException;

//import org.springframework.web.ErrorResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.Data;

@Data
public class CustomDecoder implements ErrorDecoder
{

	@Override
	public Exception decode(String methodKey, Response response) 
	{
		// TODO Auto-generated method stub
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			ErrorResponse errorResponse=objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
		    return new OrderServiceCustomException(errorResponse.getMessage(),errorResponse.getErrorCode());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OrderServiceCustomException("SERVICE_INTERNAL_EXCEPTION","SERVICE_EXCEPTION");
	}

}
