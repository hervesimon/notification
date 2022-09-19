package com.amadeus.notification.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amadeus.notification.domain.repository.UserRepository;
import com.amadeus.notification.domain.service.NotificationService;
import com.amadeus.notification.domain.service.TripService;
import com.amadeus.notification.domain.service.UserService;
import com.amadeus.notification.domain.service.impl.NotificationServiceImpl;
import com.amadeus.notification.domain.service.impl.TripServiceImpl;
import com.amadeus.notification.domain.service.impl.UserServiceImpl;

@Configuration
public class DomainConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserServiceImpl(userRepository);
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
