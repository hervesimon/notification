package com.amadeus.notification.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.notification.api.TripsApi;
import com.amadeus.notification.api.model.TripRequestJson;
import com.amadeus.notification.api.model.TripResponseJson;
import com.amadeus.notification.app.exception.WebFunctionalException;
import com.amadeus.notification.app.mapper.NotificationMapper;
import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.service.TripService;

@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class TripController implements TripsApi {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @Override
    public ResponseEntity<List<TripResponseJson>> getTrips() {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.mapTrips(this.tripService.getTrips()));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<TripResponseJson> getTripsById(String id) {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.map(this.tripService.getTripById(id)));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<TripResponseJson> postTrips(TripRequestJson tripRequest) {
        try {
            return ResponseEntity.ok(
                    NotificationMapper.INSTANCE.map(this.tripService.createTrip(NotificationMapper.INSTANCE.map(tripRequest))));
        } catch (FunctionalException e) {
            throw new WebFunctionalException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
