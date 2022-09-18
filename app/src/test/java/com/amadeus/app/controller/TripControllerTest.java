package com.amadeus.app.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.amadeus.domain.exception.FunctionalException;
import com.amadeus.domain.model.Trip;
import com.amadeus.domain.service.TripService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test class for trip controller
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(TripController.class)
@ComponentScan(basePackages = "com.amadeus.app")
@AutoConfigureMockMvc
class TripControllerTest {

    private static final String TRIPS_URL = "/api/v1/trips";
    private static final String GET_TRIP_BY_ID_URL = TRIPS_URL + "/{id}";

    ObjectMapper mapper = new ObjectMapper();
    EasyRandom generator = new EasyRandom();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    @Test
    @DisplayName("Test doit retourner une erreur 500 lorsqu'un problème technique est levé sur l'api trip")
    void when_user_technical_issue_then_error_500() throws Exception {

        when(tripService.getTrips()).thenThrow(new FunctionalException("notification.error","une erreur est arrivée"));

        this.mockMvc.perform(get(TRIPS_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.code").value("notification.error"))
                    .andExpect(jsonPath("$.message").value("une erreur est arrivée"))
                    .andExpect(status().is5xxServerError());
    }

    @Test
    @DisplayName("Test doit retourner tous les trips")
    void when_get_trips_request_then_OK() throws Exception {
        List<Trip> expectedTrips = generator.objects(Trip.class, 3).collect(Collectors.toList());
        when(tripService.getTrips()).thenReturn(expectedTrips);

        this.mockMvc.perform(get(TRIPS_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.length()").value(3))
                    .andExpect(jsonPath("$[0].id").value(expectedTrips.get(0).getId()))
                    .andExpect(jsonPath("$[0].userId").value(expectedTrips.get(0).getUserId()))
                    .andExpect(jsonPath("$[0].title").value(expectedTrips.get(0).getTitle()))
                    .andExpect(jsonPath("$[0].creationDate").value(expectedTrips.get(0).getCreationDate().toString()))
                    .andExpect(jsonPath("$[0].departureDateTime").value(expectedTrips.get(0).getDepartureDateTime().toString()+"+02:00"))
                    .andExpect(jsonPath("$[0].arrivalDateTime").value(expectedTrips.get(0).getArrivalDateTime().toString()+"+01:00"))
                    .andExpect(jsonPath("$[0].travelType").value(expectedTrips.get(0).getTravelType().toString()))
                    .andExpect(jsonPath("$[0].travelNumber").value(expectedTrips.get(0).getTravelNumber()))
                    .andExpect(jsonPath("$[0].travelDestinationCountry").value(expectedTrips.get(0).getTravelDestinationCountry()))
                    .andExpect(jsonPath("$[0].travelDestinationTown").value(expectedTrips.get(0).getTravelDestinationTown()))
                    .andExpect(jsonPath("$[0].isBusinessTrip").value(expectedTrips.get(0).getIsBusinessTrip()))
                    .andExpect(jsonPath("$[0].numberOfTraveler").value(expectedTrips.get(0).getNumberOfTraveler()))
                    .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test doit retourner un trip en fonction de son ID")
    void when_get_trips_by_id__request_then_OK() throws Exception {
        Trip expectedTrip = generator.nextObject(Trip.class);
        when(tripService.getTripById("123456")).thenReturn(expectedTrip);

        this.mockMvc.perform(get(GET_TRIP_BY_ID_URL, "123456")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.id").value(expectedTrip.getId()))
                    .andExpect(jsonPath("$.userId").value(expectedTrip.getUserId()))
                    .andExpect(jsonPath("$.title").value(expectedTrip.getTitle()))
                    .andExpect(jsonPath("$.creationDate").value(expectedTrip.getCreationDate().toString()))
                    .andExpect(jsonPath("$.departureDateTime").value(expectedTrip.getDepartureDateTime().toString()+"+02:00"))
                    .andExpect(jsonPath("$.arrivalDateTime").value(expectedTrip.getArrivalDateTime().toString()+"+01:00"))
                    .andExpect(jsonPath("$.travelType").value(expectedTrip.getTravelType().toString()))
                    .andExpect(jsonPath("$.travelNumber").value(expectedTrip.getTravelNumber()))
                    .andExpect(jsonPath("$.travelDestinationCountry").value(expectedTrip.getTravelDestinationCountry()))
                    .andExpect(jsonPath("$.travelDestinationTown").value(expectedTrip.getTravelDestinationTown()))
                    .andExpect(jsonPath("$.isBusinessTrip").value(expectedTrip.getIsBusinessTrip()))
                    .andExpect(jsonPath("$.numberOfTraveler").value(expectedTrip.getNumberOfTraveler()))
                    .andExpect(status().isOk());
    }


}