package com.github.lj128.spring.cloud.demo.producer.api;

import com.github.lj128.spring.cloud.demo.producer.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("producer")
public interface HelloServiceApi {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/getUserByName/{name}")
    @ResponseBody
    UserDto getUserByName(@PathVariable("name") String name);

}
