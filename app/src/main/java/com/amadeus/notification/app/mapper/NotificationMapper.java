package com.amadeus.notification.app.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amadeus.notification.api.model.NotificationJson;
import com.amadeus.notification.api.model.TripRequestJson;
import com.amadeus.notification.api.model.TripResponseJson;
import com.amadeus.notification.api.model.UserCredentialJson;
import com.amadeus.notification.api.model.UserInfoJson;
import com.amadeus.notification.api.model.UserRegistrationJson;
import com.amadeus.notification.domain.model.Notification;
import com.amadeus.notification.domain.model.Traveler;
import com.amadeus.notification.domain.model.Trip;
import com.amadeus.notification.domain.model.UserCredential;

@Mapper
public interface NotificationMapper {

    ZoneId zoneLocale = ZoneId.of("Europe/Paris");

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    UserInfoJson map(Traveler user);

    TripResponseJson map(Trip userTrip);
    Trip map(TripRequestJson tripRequestJson);
    List<TripResponseJson> mapTrips(List<Trip> userTrips);

    NotificationJson map(Notification userNotification);
    List<NotificationJson> mapNotifications( List<Notification> userNotifications);

    Traveler map(UserRegistrationJson userRegistration);

    UserCredential map(UserCredentialJson userCredential);

    default OffsetDateTime map(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        Instant instant = localDateTime.atZone(zoneLocale).toInstant();

        return OffsetDateTime.ofInstant(instant, zoneLocale);
    }

    default LocalDateTime map(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        Instant instant = offsetDateTime.toInstant();

        return LocalDateTime.ofInstant(instant, zoneLocale);
    }
}
