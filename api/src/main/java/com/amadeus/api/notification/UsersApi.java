package com.amadeus.api.notification;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.amadeus.api.notification.model.TripResponseJson;
import com.amadeus.api.notification.model.UserCredentialJson;
import com.amadeus.api.notification.model.UserInfoJson;
import com.amadeus.api.notification.model.UserRegistrationJson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "users", description = "the users API")
@RequestMapping("${openapi.amadeusNotification.base-path:/api}")
public interface UsersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /users/{username} : Get User Info by User ID
     * Retrieve the information of the user with the matching user ID.
     *
     * @param username  (required)
     * @return User Found (status code 200)
     *         or Forbidden (status code 403)
     *         or User Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getUsersByUserId",
        summary = "Get User Info by User ID",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserInfoJson.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users/{username}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserInfoJson> getUsersByUserId(
        @Parameter(name = "username", description = "", required = true) @PathVariable("username") String username
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    /**
     * GET /users/{username}/trips : Get User trips
     * Retrieve the trips information of the user with the matching user ID.
     *
     * @param username The unique identification of an user (required)
     * @return Trips Found (status code 200)
     *         or Forbidden (status code 403)
     *         or User Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getUsersTrips",
        summary = "Get User trips",
        tags = { "Users", "Trips" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Trips Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TripResponseJson.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "User Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users/{username}/trips",
        produces = { "application/json" }
    )
    default ResponseEntity<TripResponseJson> getUsersTrips(
        @Parameter(name = "username", description = "The unique identification of an user", required = true) @PathVariable("username") String username
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /users/register : Register
     * Create a new user.
     *
     * @param userRegistration The credentials use to create an user. (optional)
     * @return User Created (status code 201)
     *         or Missing Required Information (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "postUserRegister",
        summary = "Register",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "201", description = "User Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Missing Required Information"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/users/register",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<String> postUserRegister(
        @Parameter(name = "UserRegistration", description = "The credentials use to create an user.") @Valid @RequestBody(required = false) UserRegistrationJson userRegistration
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /users/login : Login
     * Allow an user to log in the system.
     *
     * @param userCredential The username and password use to login. (optional)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "postUsersLogin",
        summary = "Login",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/users/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<String> postUsersLogin(
        @Parameter(name = "UserCredential", description = "The username and password use to login.") @Valid @RequestBody(required = false) UserCredentialJson userCredential
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
