package com.amadeus.domain.service;

import java.util.List;

import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.model.Trip;

public interface TripService {
    List<Trip> getTrips() throws FunctionalException;

    List<Trip> getUserTrips(String username) throws FunctionalException;

    Trip getTripById(String id) throws FunctionalException;

    Trip createTrip(Trip triprequest) throws FunctionalException;
}
