package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    User findUserByUsername(String username);

    User findUserByApiKey(String apiKey);

    List<User> findAllUsers();

    User saveUser(User user);
}
