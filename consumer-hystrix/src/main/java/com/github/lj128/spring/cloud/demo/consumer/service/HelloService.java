package com.github.lj128.spring.cloud.demo.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(groupKey = "hello", commandKey = "hello", threadPoolKey = "hello",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    //控制实际处理请求超时中断
                    @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000")
            },
            fallbackMethod = "helloFallback"
    )
    public String hello() {
//        return restTemplate.getForObject("http://producer/hello", String.class);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("i am running [" + Thread.currentThread().getId() + "]");
            }
            System.out.println("interrupted [" + Thread.currentThread().getId() + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hystrix test";
    }

    public String helloFallback() {
        return "Fallback";
    }
}
