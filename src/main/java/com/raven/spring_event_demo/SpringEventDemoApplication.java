package com.raven.spring_event_demo;

import com.raven.spring_event_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEventDemoApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringEventDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Starting user registration process ---");
        userService.registerUser("john_doe", "john.doe@example.com");
        System.out.println("--- User registration process complete ---");

        System.out.println("\nRegistering another user...");
        userService.registerUser("jane_smith", "jane.smith@example.com");
    }

}
