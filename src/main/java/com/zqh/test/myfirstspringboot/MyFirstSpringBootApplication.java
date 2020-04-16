package com.zqh.test.myfirstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
// 重试
@EnableRetry
// 异步
@EnableAsync
@ServletComponentScan
@SpringBootApplication
@ImportResource("classpath:spring-mvc.xml")
public class MyFirstSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringBootApplication.class, args);
    }
}
