package com.github.lj128.spring.cloud.demo.producer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;


/**
 * Created by liujia on  10:48
 */
@RunWith(SpringRunner.class)
public class HelloServiceTest {

    @SpyBean
    private HelloService helloService;

    @MockBean
    private AService aService;

    @Test
    public void test1(){
        when(helloService.hello()).thenReturn("mockito test");
        System.out.println(helloService.hello());
    }
}
