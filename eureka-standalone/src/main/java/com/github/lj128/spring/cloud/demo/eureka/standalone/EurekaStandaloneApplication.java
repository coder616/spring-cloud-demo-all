package com.github.lj128.spring.cloud.demo.eureka.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaStandaloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaStandaloneApplication.class, args);
    }

}
