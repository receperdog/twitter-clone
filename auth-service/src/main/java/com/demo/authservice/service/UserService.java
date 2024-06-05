package com.demo.authservice.service;

import com.demo.authservice.dtos.UserRegisterRequest;
import com.demo.authservice.model.User;

import java.util.Optional;

public interface UserService {

    void saveUser(UserRegisterRequest user);
    Optional<User> findByUsername(String username);
}
