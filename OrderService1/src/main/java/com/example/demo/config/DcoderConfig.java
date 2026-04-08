package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.exception.dcoder.CustomDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class DcoderConfig 
{
	@Bean
	 public ErrorDecoder createConfig()
	 {
		 return new CustomDecoder();
	 }
}
