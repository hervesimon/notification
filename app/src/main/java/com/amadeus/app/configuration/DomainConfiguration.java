package com.amadeus.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amadeus.domain.service.NotificationService;
import com.amadeus.domain.service.TripService;
import com.amadeus.domain.service.UserService;
import com.amadeus.domain.service.impl.NotificationServiceImpl;
import com.amadeus.domain.service.impl.TripServiceImpl;
import com.amadeus.domain.service.impl.UserServiceImpl;

@Configuration
public class DomainConfiguration {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public TripService tripService(){
        return new TripServiceImpl();
    }

    @Bean
    public NotificationService notificationService(){
        return new NotificationServiceImpl();
    }
}
