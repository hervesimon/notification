package com.amadeus.api.notification.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UserRegistration
 */
@Schema(name = "UserRegistration", description = "Basic user informations to register")
public class UserRegistrationJson {

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("dateOfBirth")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  public UserRegistrationJson username(String username) {
    this.username = username;
    return this;
  }

  /**
   * The username that will be used to log in the system
   * @return username
  */
  @NotNull 
  @Schema(name = "username", description = "The username that will be used to log in the system", required = true)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserRegistrationJson password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The password (not encrypted)
   * @return password
  */
  @NotNull 
  @Schema(name = "password", description = "The password (not encrypted)", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRegistrationJson firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The user's firstname
   * @return firstName
  */
  
  @Schema(name = "firstName", description = "The user's firstname", required = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserRegistrationJson lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The user's lastname
   * @return lastName
  */
  
  @Schema(name = "lastName", description = "The user's lastname", required = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserRegistrationJson email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user's email
   * @return email
  */
  @Email
  @Schema(name = "email", description = "The user's email", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserRegistrationJson dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * The user's date of birth (MM/DD/YYYY)
   * @return dateOfBirth
  */
  @Valid 
  @Schema(name = "dateOfBirth", example = "Fri Oct 31 01:00:00 CET 1997", description = "The user's date of birth (MM/DD/YYYY)", required = false)
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRegistrationJson userRegistration = (UserRegistrationJson) o;
    return Objects.equals(this.username, userRegistration.username) &&
        Objects.equals(this.password, userRegistration.password) &&
        Objects.equals(this.firstName, userRegistration.firstName) &&
        Objects.equals(this.lastName, userRegistration.lastName) &&
        Objects.equals(this.email, userRegistration.email) &&
        Objects.equals(this.dateOfBirth, userRegistration.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, firstName, lastName, email, dateOfBirth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRegistration {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

