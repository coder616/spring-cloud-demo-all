package com.github.lj128.spring.cloud.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerFeignApplication.class, args);
    }
}
