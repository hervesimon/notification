package com.amadeus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = { "com.amadeus.app" })
public class NotificationRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationRestApplication.class, args);
    }

}
