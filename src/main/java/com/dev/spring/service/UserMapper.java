package com.dev.spring.service;

import com.dev.spring.dto.UserResponseDto;
import com.dev.spring.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        return responseDto;
    }
}
