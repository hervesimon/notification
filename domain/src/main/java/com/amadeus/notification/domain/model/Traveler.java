package com.amadeus.notification.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * User informations
 */

public class Traveler {

  private Integer id;

  private String firstName;

  private String lastName;

  private String email;

  private LocalDate dateOfBirth;

  private LocalDate createDate;

  private String phoneNumber;

  public Traveler id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the given user.
   * @return id
  */
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Traveler firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The user first name
   * @return firstName
  */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Traveler lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The user last name.
   * @return lastName
  */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Traveler email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user email
   * @return email
  */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Traveler dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * The user birth name in format MM/DD/YYYY
   * @return dateOfBirth
  */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Traveler createDate(LocalDate createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * The date that the user was created.
   * @return createDate
  */
  public LocalDate getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDate createDate) {
    this.createDate = createDate;
  }

  public Traveler phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * International phone number of the user
   * @return phoneNumber
  */
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
    Traveler userInfo = (Traveler) o;
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

