package com.amadeus.notification.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.notification.api.UsersApi;
import com.amadeus.notification.api.model.NotificationJson;
import com.amadeus.notification.api.model.TripResponseJson;
import com.amadeus.notification.api.model.UserCredentialJson;
import com.amadeus.notification.api.model.UserInfoJson;
import com.amadeus.notification.api.model.UserRegistrationJson;
import com.amadeus.notification.app.exception.WebFunctionalException;
import com.amadeus.notification.app.mapper.NotificationMapper;
import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.service.NotificationService;
import com.amadeus.notification.domain.service.TripService;
import com.amadeus.notification.domain.service.UserService;

@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class UserController implements UsersApi {

    private final UserService userService;
    private final NotificationService notificationService;
    private final TripService tripService;

    public UserController(UserService userService, NotificationService notificationService, TripService tripService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.tripService = tripService;
    }

    @Override
    public ResponseEntity<UserInfoJson> getUsersByUserId(String username) {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.map(this.userService.getTravelerInfo(username)));
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
