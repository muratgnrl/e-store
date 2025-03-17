package com.example.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	/*bir HTTP istemcisidir ve başka servislerle iletişim kurmak için HTTP istekleri göndermeye yarar.
			Get, Post, Put, Delete gibi HTTP isteklerini yapmak için kullanılır.
	Spring Boot’ta genellikle dış API’lere veya mikroservisler arası iletişim için kullanılır.*/
}
