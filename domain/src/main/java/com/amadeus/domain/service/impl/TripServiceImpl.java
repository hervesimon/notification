package com.amadeus.domain.service.impl;

import java.util.List;

import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.model.Trip;
import com.amadeus.domain.service.TripService;

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
