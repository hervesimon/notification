package com.amadeus.notification.app.controller;

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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.amadeus.notification.app.security.JwtTokenProvider;
import com.amadeus.notification.domain.exception.FunctionalException;
import com.amadeus.notification.domain.model.Notification;
import com.amadeus.notification.domain.model.Traveler;
import com.amadeus.notification.domain.model.Trip;
import com.amadeus.notification.domain.service.NotificationService;
import com.amadeus.notification.domain.service.TripService;
import com.amadeus.notification.domain.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test class for user controller
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@WithMockUser
class UsersControllerTest {

    private static final String GET_USER_BY_USERNAME_URL = "/api/v1/users/{username}";
    private static final String GET_TRIPS_BY_USERNAME_URL = "/api/v1/users/{username}/trips";
    private static final String GET_NOTIFICATIONS_BY_USERNAME_URL = "/api/v1/users/{username}/notifications";

    ObjectMapper mapper = new ObjectMapper();
    EasyRandom generator = new EasyRandom();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private TripService tripService;

    @MockBean
    private NotificationService notificationService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;


    @Test
    @DisplayName("Test doit retourner une erreur 500 lorsqu'un problème technique est levé sur l'api user")
    void when_user_technical_issue_then_error_500() throws Exception {

        when(userService.getTravelerInfo("johndoe")).thenThrow(new FunctionalException("notification.error","une erreur est arrivée"));

        this.mockMvc.perform(get(GET_USER_BY_USERNAME_URL, "johndoe")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.code").value("notification.error"))
                    .andExpect(jsonPath("$.message").value("une erreur est arrivée"))
                    .andExpect(status().is5xxServerError());
    }

    @Test
    @DisplayName("Test doit retourner une erreur 500 lorsqu'un problème technique est levé sur l'api trip")
    void when_trip_technical_issue_then_error_500() throws Exception {

        when(tripService.getUserTrips("johndoe")).thenThrow(new FunctionalException("notification.error","une erreur est arrivée"));

        this.mockMvc.perform(get(GET_TRIPS_BY_USERNAME_URL, "johndoe")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.code").value("notification.error"))
                    .andExpect(jsonPath("$.message").value("une erreur est arrivée"))
                    .andExpect(status().is5xxServerError());
    }

    @Test
    @DisplayName("Test doit retourner une erreur 500 lorsqu'un problème technique est levé sur l'api notification")
    void when_notification_technical_issue_then_error_500() throws Exception {

        when(notificationService.getUserNotifications("johndoe")).thenThrow(new FunctionalException("notification.error","une erreur est arrivée"));

        this.mockMvc.perform(get(GET_NOTIFICATIONS_BY_USERNAME_URL, "johndoe")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.code").value("notification.error"))
                    .andExpect(jsonPath("$.message").value("une erreur est arrivée"))
                    .andExpect(status().is5xxServerError());
    }

    @Test
    @DisplayName("Test doit retourner les informations utilisateurs")
    void when_username_trips_request_then_OK() throws Exception {
        Traveler expectedUser = generator.nextObject(Traveler.class);
        when(userService.getTravelerInfo("johndoe")).thenReturn(expectedUser);
        this.mockMvc.perform(get(GET_USER_BY_USERNAME_URL, "johndoe")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.id").value(expectedUser.getId()))
                    .andExpect(jsonPath("$.firstName").value(expectedUser.getFirstName()))
                    .andExpect(jsonPath("$.lastName").value(expectedUser.getLastName()))
                    .andExpect(jsonPath("$.email").value(expectedUser.getEmail()))
                    .andExpect(jsonPath("$.dateOfBirth").value(expectedUser.getDateOfBirth().toString()))
                    .andExpect(jsonPath("$.createDate").value(expectedUser.getCreateDate().toString()))
                    .andExpect(jsonPath("$.phoneNumber").value(expectedUser.getPhoneNumber()))
                    .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test doit retourner les trips d'un utilisateur")
    void when_username_get_trips_request_then_OK() throws Exception {
        List<Trip> expectedTrips = generator.objects(Trip.class, 3).collect(Collectors.toList());
        when(tripService.getUserTrips("johndoe")).thenReturn(expectedTrips);

        this.mockMvc.perform(get(GET_TRIPS_BY_USERNAME_URL, "johndoe")
                    .header(HttpHeaders.AUTHORIZATION, "Bearer token")
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
    @DisplayName("Test doit retourner les notifications d'un utilisateur")
    void when_username_get_notifications_request_then_OK() throws Exception {
        List<Notification> expectedNotifications = generator.objects(Notification.class, 3).collect(Collectors.toList());
        when(notificationService.getUserNotifications("johndoe")).thenReturn(expectedNotifications);
        this.mockMvc.perform(get(GET_NOTIFICATIONS_BY_USERNAME_URL, "johndoe")
                    .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF8"))
                    .andExpect(jsonPath("$.length()").value(3))
                    .andExpect(jsonPath("$[0].id").value(expectedNotifications.get(0).getId()))
                    .andExpect(jsonPath("$[0].description").value(expectedNotifications.get(0).getDescription()))
                    .andExpect(jsonPath("$[0].creationDateTime").value(expectedNotifications.get(0).getCreationDateTime().toString()+"+02:00"))
                    .andExpect(status().isOk());
    }

}