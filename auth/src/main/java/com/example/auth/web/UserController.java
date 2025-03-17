package com.example.auth.web;

import com.example.auth.api.UserDto;
import com.example.auth.api.UserService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService service;
    @PostMapping("/save")
    public UserResponse save(@RequestBody UserRequest userRequest){
        return toResponse(service.addUser(userRequest.toDto()));
    }

    @GetMapping("/{id}")
    public UserResponse getUserId(@PathVariable String id){

        return toResponse(service.getUser(id));

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        service.deleteUser(id);
        return "User deleted successfuly";
    }
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable String id , @RequestBody UserRequest userRequest){
        return toResponse(service.updateUser(id,userRequest.toDto()));
    }
    @GetMapping
    public List<UserResponse> getAllUsers(){
        return service.getAllUsers().stream().map(userDto -> toResponse(userDto)).collect(Collectors.toList());
    }


    public UserResponse toResponse(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userDto.getUserId());
        userResponse.setFirstName(userDto.getFirstName());
        userResponse.setLastName(userDto.getLastName());
        userResponse.setEmail(userDto.getEmail());
        userResponse.setPassword(userDto.getPassword());
        userResponse.setRole(userDto.getRole());
        return userResponse;
    }

}
