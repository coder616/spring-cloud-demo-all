package com.github.lj128.spring.cloud.demo.producer.controller;

import com.github.lj128.spring.cloud.demo.producer.dto.UserDto;
import com.github.lj128.spring.cloud.demo.producer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("getUserByName/{name}")
    @ResponseBody
    public UserDto getUserByName(@PathVariable("name") String name) {
        return helloService.getUserByName(name);
    }

}
