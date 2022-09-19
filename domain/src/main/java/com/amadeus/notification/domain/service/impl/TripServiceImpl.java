package com.amadeus.notification.domain.service.impl;

import java.util.List;

import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Trip;
import com.amadeus.notification.domain.service.TripService;

public class TripServiceImpl implements TripService {
    @Override
    public List<Trip> getTrips() throws FunctionalException {
        return null;
    }

    @Override
    public List<Trip> getUserTrips(String username) throws FunctionalException {
        return null;
    }

    @Override
    public Trip getTripById(String id) throws FunctionalException {
        return null;
    }

    @Override
    public Trip createTrip(Trip triprequest) throws FunctionalException {
        return null;
    }
}
