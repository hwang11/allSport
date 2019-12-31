package com.teamSupport.allSport;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
public class runApi {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(runApi.class, args);
    }
}
