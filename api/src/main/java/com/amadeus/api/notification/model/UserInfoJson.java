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
 * User informations
 */

@Schema(name = "UserInfo", description = "User informations")
public class UserInfoJson {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("dateOfBirth")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  @JsonProperty("createDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate createDate;

  @JsonProperty("phoneNumber")
  private String phoneNumber;

  public UserInfoJson id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the given user.
   * @return id
  */
  
  @Schema(name = "id", description = "Unique identifier for the given user.", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserInfoJson firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The user first name
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", description = "The user first name", required = true)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserInfoJson lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The user last name.
   * @return lastName
  */
  @NotNull 
  @Schema(name = "lastName", description = "The user last name.", required = true)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserInfoJson email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user email
   * @return email
  */
  @NotNull @Email
  @Schema(name = "email", description = "The user email", required = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfoJson dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * The user birth name in format MM/DD/YYYY
   * @return dateOfBirth
  */
  @Valid 
  @Schema(name = "dateOfBirth", example = "Fri Oct 31 01:00:00 CET 1997", description = "The user birth name in format MM/DD/YYYY", required = false)
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public UserInfoJson createDate(LocalDate createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * The date that the user was created.
   * @return createDate
  */
  @Valid 
  @Schema(name = "createDate", description = "The date that the user was created.", required = false)
  public LocalDate getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDate createDate) {
    this.createDate = createDate;
  }

  public UserInfoJson phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * International phone number of the user
   * @return phoneNumber
  */
  
  @Schema(name = "phoneNumber", description = "International phone number of the user", required = false)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfoJson userInfo = (UserInfoJson) o;
    return Objects.equals(this.id, userInfo.id) &&
        Objects.equals(this.firstName, userInfo.firstName) &&
        Objects.equals(this.lastName, userInfo.lastName) &&
        Objects.equals(this.email, userInfo.email) &&
        Objects.equals(this.dateOfBirth, userInfo.dateOfBirth) &&
        Objects.equals(this.createDate, userInfo.createDate) &&
        Objects.equals(this.phoneNumber, userInfo.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, dateOfBirth, createDate, phoneNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
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

