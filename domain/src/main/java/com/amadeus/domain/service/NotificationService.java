package com.amadeus.domain.service;

import java.util.List;

import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.model.Notification;

public interface NotificationService {
    List<Notification> getUserNotifications(String johndoe) throws FunctionalException;
}
