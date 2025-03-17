package com.example.auth.api;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto dto);

    UserDto getUser(String id);

    void deleteUser(String id);

    UserDto updateUser(String id, UserDto dto);

    List<UserDto> getAllUsers();
}
