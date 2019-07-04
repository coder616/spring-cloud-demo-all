package com.github.lj128.spring.cloud.demo.producer.service;

import com.github.lj128.spring.cloud.demo.producer.feign.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    public String hello() {
        log.info("requesting producer-feign for hello !");
        return "I am is producer-feign !";
    }

    public UserDto getUserByName(String name) {
        log.info("requesting producer-feign for getUserByName !");
        UserDto userDto = new UserDto();
        userDto.setUserName(name);
        userDto.setPassword("*****");
        return userDto;
    }
}
