package com.amadeus.notification.domain.service;

import java.util.List;

import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Trip;

public interface TripService {
    List<Trip> getTrips() throws FunctionalException;

    List<Trip> getUserTrips(String username) throws FunctionalException;

    Trip getTripById(String id) throws FunctionalException;

    Trip createTrip(Trip triprequest) throws FunctionalException;
}
