package com.dev.spring.service;

import com.dev.spring.dto.UserResponseDto;
import com.dev.spring.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        return responseDto;
    }

    public User toUser(UserResponseDto userResponseDto) {
        User user = new User();
        user.setName(userResponseDto.getName());
        user.setAge(userResponseDto.getAge());
        return user;
    }
}
