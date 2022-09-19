package com.amadeus.notification.domain.repository;

import com.amadeus.notification.domain.model.UserCredential;

public interface UserRepository {
    UserCredential findByUsername(String userName);
}
