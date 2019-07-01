package com.github.lj128.spring.cloud.demo.producer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -3342212676940107214L;
    private String userName;
    private String password;
}
