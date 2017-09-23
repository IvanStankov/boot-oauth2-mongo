package com.ivan.bootexamples.controller;

import com.ivan.bootexamples.entity.User;
import com.ivan.bootexamples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable final String username) {
        return this.userService.getByUsername(username);
    }

}
