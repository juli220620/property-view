package com.github.juli220620;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static final String ROOT = "/property-view";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
