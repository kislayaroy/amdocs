package com.uxpsystems.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Please Login to http://localhost:9090");
        System.out.println("UserName: amdocs");
        System.out.println("Password: amdocs");
    }
}
