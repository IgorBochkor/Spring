package com.dev.spring;

import com.dev.spring.config.AppConfig;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) {

        User user1 = new User();
        user1.setName("Bob");
        user1.setAge(15);

        User user2 = new User();
        user2.setName("John");
        user2.setAge(25);

        UserService userService = context.getBean(UserService.class);
        userService.add(user1);
        userService.add(user2);

        List<User> users = userService.listUsers();
        System.out.println(users);
    }
}
