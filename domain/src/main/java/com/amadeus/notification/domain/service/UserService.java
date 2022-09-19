package com.amadeus.notification.domain.service;

import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Traveler;
import com.amadeus.notification.domain.model.UserCredential;

public interface UserService {
    UserCredential getUserName(String userName) throws FunctionalException;;

    String registerUser(Traveler user) throws FunctionalException;
    String loginUser(UserCredential credential) throws FunctionalException;

    Traveler getTravelerInfo(String username) throws FunctionalException;
}
