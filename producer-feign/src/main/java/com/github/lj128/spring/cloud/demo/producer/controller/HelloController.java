package com.github.lj128.spring.cloud.demo.producer.controller;

import com.github.lj128.spring.cloud.demo.producer.feign.api.HelloServiceApi;
import com.github.lj128.spring.cloud.demo.producer.feign.dto.UserDto;
import com.github.lj128.spring.cloud.demo.producer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloServiceApi {

    @Autowired
    private HelloService helloService;

    public String hello() {
        return helloService.hello();
    }

    /**
     * 注意实现类必须加@PathVariable注解 否则取不到参数
     * @param name
     * @return
     */
    public UserDto getUserByName(@PathVariable("name") String name) {
        return helloService.getUserByName(name);
    }
}
