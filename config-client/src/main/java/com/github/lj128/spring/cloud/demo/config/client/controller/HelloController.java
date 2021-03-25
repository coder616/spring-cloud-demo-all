package com.github.lj128.spring.cloud.demo.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${config.test}")
    private String var;

    @GetMapping("/hello")
    public String hello() {
        return "hello i am is config client !"+var;
    }
}
