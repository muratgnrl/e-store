package com.example.basket.library;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "auth")
public class AuthFeignClient {
}
