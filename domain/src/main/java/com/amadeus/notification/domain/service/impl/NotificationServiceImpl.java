package com.amadeus.notification.domain.service.impl;

import java.util.List;

import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Notification;
import com.amadeus.notification.domain.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public List<Notification> getUserNotifications(String johndoe) throws FunctionalException {
        return null;
    }
}
