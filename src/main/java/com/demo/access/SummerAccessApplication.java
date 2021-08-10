package com.demo.access;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.demo.access.mapper")
public class SummerAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummerAccessApplication.class, args);
    }

}
