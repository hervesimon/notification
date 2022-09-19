package com.amadeus.notification.domain.service.impl;

import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Traveler;
import com.amadeus.notification.domain.model.UserCredential;
import com.amadeus.notification.domain.repository.UserRepository;
import com.amadeus.notification.domain.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCredential getUserName(String userName) throws FunctionalException {
        return userRepository.findByUsername(userName);
    }

    @Override
    public String registerUser(Traveler user) throws FunctionalException {
        return null;
    }

    @Override
    public String loginUser(UserCredential credential) throws FunctionalException {
        return null;
    }

    @Override
    public Traveler getTravelerInfo(String username) throws FunctionalException {
        return null;
    }
}
