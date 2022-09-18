package com.amadeus.domain.service;

import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.model.User;
import com.amadeus.domain.model.UserCredential;

public interface UserService {
    User getUserName(String userName) throws FunctionalException;;

    String registerUser(User user) throws FunctionalException;
    String loginUser(UserCredential credential) throws FunctionalException;
}
