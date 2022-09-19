package com.amadeus.notification.infra.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableMongoRepositories(basePackages = "com.amadeus.notification.infra.db")
@EnableTransactionManagement
public class DBConfiguration {

}
