package com.ivan.bootexamples.service;

import com.ivan.bootexamples.entity.User;

public interface UserService {

    User getByUsername(String username);

}
