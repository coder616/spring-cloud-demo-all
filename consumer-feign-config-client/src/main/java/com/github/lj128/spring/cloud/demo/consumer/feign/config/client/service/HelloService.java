package com.github.lj128.spring.cloud.demo.consumer.feign.config.client.service;

import com.github.lj128.spring.cloud.demo.producer.feign.dto.UserDto;
import com.github.lj128.spring.cloud.demo.producer.feign.api.HelloServiceApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {
    @Autowired
    private HelloServiceApi helloServiceApi;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
        log.info("reuqesting consumer-feign for hello");
        return helloServiceApi.hello();
    }

    @HystrixCommand(fallbackMethod = "getUserByNameFallback")
    public UserDto getUserByName(String name) {
        log.info("reuqesting consumer-feign for getUserByName");
        return helloServiceApi.getUserByName(name);
    }

    public String helloFallback() {
        return "error";
    }

    public UserDto getUserByNameFallback(String name) {
        UserDto userDto = new UserDto();
        userDto.setUserName("default");
        userDto.setPassword("*******");
        return userDto;
    }
}
