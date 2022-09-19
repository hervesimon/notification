package com.amadeus.notification.infra.db.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amadeus.notification.infra.db.entity.AppUser;

public interface UserRepositoryDao extends MongoRepository<AppUser, Long> {

    boolean existsByUsername(String username);

    AppUser findByUsername(String username);
}
