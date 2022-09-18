package com.amadeus.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.api.notification.UsersApi;
import com.amadeus.api.notification.model.NotificationJson;
import com.amadeus.api.notification.model.TripResponseJson;
import com.amadeus.api.notification.model.UserCredentialJson;
import com.amadeus.api.notification.model.UserInfoJson;
import com.amadeus.api.notification.model.UserRegistrationJson;
import com.amadeus.app.exception.WebFunctionalException;
import com.amadeus.app.mapper.NotificationMapper;
import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.service.NotificationService;
import com.amadeus.domain.service.TripService;
import com.amadeus.domain.service.UserService;

@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class UserController implements UsersApi {

    private UserService userService;
    private NotificationService notificationService;
    private TripService tripService;

    public UserController(UserService userService, NotificationService notificationService, TripService tripService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.tripService = tripService;
    }

    @Override
    public ResponseEntity<UserInfoJson> getUsersByUserId(String username) {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.map(this.userService.getUserName(username)));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<TripResponseJson>> getUsersTrips(String username) {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.mapTrips(this.tripService.getUserTrips(username)));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> postUserRegister(UserRegistrationJson userRegistration) {
        try {
            return ResponseEntity.ok(this.userService.registerUser(NotificationMapper.INSTANCE.map(userRegistration)));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> postUsersLogin(UserCredentialJson userCredential) {
        try {
            return ResponseEntity.ok(this.userService.loginUser(NotificationMapper.INSTANCE.map(userCredential)));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<NotificationJson>> getUsersNotification(String username) {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.mapNotifications(this.notificationService.getUserNotifications(username)));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
