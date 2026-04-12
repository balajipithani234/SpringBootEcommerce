package com.example.spring.config;

import org.springframework.context.annotation.Configuration;

//package com.thiruacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()

        		 // ORDER SERVICE
                .route("order-service", r -> r
                    .path("/order/**")
                    .filters(f -> f.circuitBreaker(c -> c
                        .setName("orderCircuitBreaker")
                        .setFallbackUri("forward:/orderServiceFallBack")))
                    .uri("lb://ORDERSERVICE1"))


                // PRODUCT SERVICE
                .route("product-service", r -> r
                        .path("/product/**")
                        .filters(f -> f.circuitBreaker(c -> c
                            .setName("productCircuitBreaker")
                            .setFallbackUri("forward:/productServiceFallBack")))
                        .uri("lb://PRODUCTSERVICE1"))

                // PAYMENT SERVICE
                .route("payment-service", r -> r
                	    .path("/payment/**")
                	    .filters(f -> f.circuitBreaker(c -> c
                	        .setName("paymentCircuitBreaker")
                	        .setFallbackUri("forward:/paymentServiceFallBack")))
                	    .uri("lb://PAYMENTSERVICE"))

                .build();
    }
}