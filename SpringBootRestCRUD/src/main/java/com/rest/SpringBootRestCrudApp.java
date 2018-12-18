package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@SpringBootApplication(scanBasePackages={"com.rest"})
public class SpringBootRestCrudApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestCrudApp.class, args);
    }
}