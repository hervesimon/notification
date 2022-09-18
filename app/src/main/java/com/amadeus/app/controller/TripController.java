package com.amadeus.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.api.notification.TripsApi;
import com.amadeus.api.notification.model.TripRequestJson;
import com.amadeus.api.notification.model.TripResponseJson;
import com.amadeus.app.exception.WebFunctionalException;
import com.amadeus.app.mapper.NotificationMapper;
import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.service.TripService;

@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class TripController implements TripsApi {

    private TripService tripService;

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
