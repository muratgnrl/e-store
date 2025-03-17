package com.example.basket.library;

import com.example.basket.basket.api.user.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AuthCallableFeignClient {
    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return null;
    }
}
