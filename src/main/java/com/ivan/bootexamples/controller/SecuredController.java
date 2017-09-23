package com.ivan.bootexamples.controller;

import com.ivan.bootexamples.model.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {

    @GetMapping("/secured/hello")
    public HelloModel securedHello() {
        final String username = "Ivan";
        return new HelloModel(username, "It is secured controller");
    }

}
