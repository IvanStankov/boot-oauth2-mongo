package com.ivan.bootexamples.controller;

import com.ivan.bootexamples.model.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloModel hello() {
        return new HelloModel("John", "Welcome!");
    }

}
