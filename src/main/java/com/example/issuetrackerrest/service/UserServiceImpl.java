package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private final UserRepository mUserRepository;

    public UserServiceImpl(UserRepository mUserRepository) {
        this.mUserRepository = mUserRepository;
    }

    @Override
    public User findUserById(Long id) {
        return mUserRepository.findById(id).get();
    }

    @Override
    public User findUserByUsername(String username) {
        return mUserRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return mUserRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return mUserRepository.save(user);
    }

    @Override
    public User findUserByApiKey(String apiKey) {
        return mUserRepository.findByApikey(apiKey);
    }
}
