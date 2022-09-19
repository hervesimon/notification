package com.amadeus.notification.domain.service;

import java.util.List;

import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Notification;

public interface NotificationService {
    List<Notification> getUserNotifications(String johndoe) throws FunctionalException;
}
