package com.example.mybatsedemo.pludemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class PluDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PluDemoApplication.class, args);
    }

}
