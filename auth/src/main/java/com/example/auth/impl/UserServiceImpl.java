package com.example.auth.impl;

import com.example.auth.api.UserDto;
import com.example.auth.api.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDto addUser(UserDto dto) {
        User user = toEntity(dto);
        user=repository.save(user);
        return toDto(user);
    }

    @Override
    public UserDto getUser(String id) {
        return toDto(repository.findById(Long.valueOf(id)).get());
    }

    @Override
    public void deleteUser(String id) {
        User user =repository.findById(Long.valueOf(id)).get();
        repository.delete(user);
    }

    @Override
    public UserDto updateUser(String id, UserDto dto) {

        User user = repository.findById(Long.valueOf(id)).get();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        user=repository.save(user);

        return toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream().map(user -> toDto(user)).collect(Collectors.toList());
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        userDto.setRole(user.getRole());
        return userDto;
    }


    public User toEntity(UserDto userDto){
        if(userDto == null) {
            throw new IllegalArgumentException("UserDto cannot be null");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }

}
