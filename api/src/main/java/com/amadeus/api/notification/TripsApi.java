package com.amadeus.api.notification;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amadeus.api.notification.model.TripRequestJson;
import com.amadeus.api.notification.model.TripResponseJson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "trips", description = "the trips API")
@RequestMapping("${openapi.amadeusNotification.base-path:/api}")
public interface TripsApi {

    /**
     * GET /trips : GetTrips
     * Retrieve all the trips from the database
     *
     * @return The list of all the trips (status code 200)
     *         or Bad Request (status code 400)
     *         or Forbidden (status code 403)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getTrips",
        summary = "GetTrips",
        tags = { "Trips" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of all the trips", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TripResponseJson.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/trips",
        produces = { "application/json" }
    )
    default ResponseEntity<TripResponseJson> getTrips(
        
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /trips/{id} : GetTripId
     * Retrieve all information for a specific trip based on its id.
     *
     * @param id The unique id of the trip (required)
     * @return The requested trip (status code 200)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getTripsById",
        summary = "GetTripId",
        tags = { "Trips" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The requested trip", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TripResponseJson.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/trips/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<TripResponseJson> getTripsById(
        @Parameter(name = "id", description = "The unique id of the trip", required = true) @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    /**
     * POST /trips : Create trip
     * Create a new trip for an user
     *
     * @param tripRequest  (optional)
     * @return  (status code 201)
     *         or Bad Request (status code 400)
     *         or Forbidden (status code 403)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "postTrips",
        summary = "Create trip",
        tags = { "Trips" },
        responses = {
            @ApiResponse(responseCode = "201", description = "", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TripResponseJson.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/trips",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TripResponseJson> postTrips(
        @Parameter(name = "TripRequest", description = "") @Valid @RequestBody(required = false) TripRequestJson tripRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
