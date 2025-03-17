package com.example.auth.web;

import com.example.auth.api.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private int role;


    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setFirstName(this.firstname);
        userDto.setLastName(this.lastname);
        userDto.setPassword(this.password);
        userDto.setEmail(this.email);
        userDto.setRole(this.role);
        return userDto;
    }

}
