package com.github.lj128.spring.cloud.demo.consumer.feign.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.github.lj128.spring.cloud.demo.producer.feign")
@EnableCircuitBreaker
public class ConsumerFeignConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignConfigClientApplication.class, args);
    }
}
