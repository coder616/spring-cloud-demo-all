package com.github.lj128.spring.cloud.demo.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
//        return restTemplate.getForObject("http://producer/hello", String.class);
        while (true) {
            //熔断并不会中断正在处理的线程
            System.out.println("i am running ["+Thread.currentThread().getId()+"]");
        }
//        return "Hystrix test";
    }

    public String helloFallback() {
        return "Fallback";
    }
}
