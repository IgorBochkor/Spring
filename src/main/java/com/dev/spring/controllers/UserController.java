package com.dev.spring.controllers;

import com.dev.spring.dto.UserResponseDto;
import com.dev.spring.model.User;
import com.dev.spring.service.UserMapper;
import com.dev.spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User[] users = new User[4];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
            users[i].setName("Bob " + i);
            users[i].setAge(15 + i);
            userService.add(users[i]);
        }
        return "Users correctly added to DB";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userMapper.toDto(userService.getUser(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
