package com.example.basket.basket.api.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int role;
}
