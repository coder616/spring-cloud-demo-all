package com.github.lj128.spring.cloud.demo.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {


    @RequestMapping("hello")
    public String hello() {
        log.info("I am is com.github.lj128.spring.cloud.demo.producer");
//        try {
//            Thread.sleep(60*1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "Hello World,I am is producer!";
    }
}
