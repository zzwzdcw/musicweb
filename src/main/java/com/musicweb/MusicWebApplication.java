package com.musicweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.musicweb.dao")
@ComponentScan("com.musicweb.entity")
@ComponentScan("com.musicweb.controller")
@MapperScan("com.musicweb.dao")
@SpringBootApplication
public class MusicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicWebApplication.class, args);
        System.out.println("--------------------开始了-----------------------");
    }

}
