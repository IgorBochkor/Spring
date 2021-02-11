package com.dev.spring.dao;

import com.dev.spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    Optional<User> getUser(Long id);
}
