package com.amadeus.notification.infra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "infra.yml")
public class InfraConfiguration {

}

