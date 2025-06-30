package com.example.baseTemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.baseTemplate.mapper")
public class BaseTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseTemplateApplication.class, args);
    }
}