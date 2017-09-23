package com.ivan.bootexamples.service.impl;

import com.ivan.bootexamples.entity.User;
import com.ivan.bootexamples.repository.UserRepository;
import com.ivan.bootexamples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
