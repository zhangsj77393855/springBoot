package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:tx-annotation.xml")
@SpringBootApplication
public class Springboot15SqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15SqlApplication.class, args);
    }

}
