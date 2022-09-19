package com.amadeus.notification.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The informartions for a user&#39;s trip.
 */

public class Trip {

  private String id;

  private Long userId;

  private String title;

  private LocalDate creationDate;

  private LocalDateTime departureDateTime;

  private LocalDateTime arrivalDateTime;

  /**
   * The type of travel of the trip
   */
  public enum TravelTypeEnum {
    FLIGHT("FLIGHT"),
    
    TRAIN("TRAIN"),
    
    BOAT("BOAT"),
    
    STARTSHIP("STARTSHIP");

    private String value;

    TravelTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private TravelTypeEnum travelType;

  private String travelNumber;

  private String travelDestinationCountry;

  private String travelOriginCountry;

  private String travelDestinationTown;

  private String travelOriginCountryTown;

  private String isBusinessTrip;

  private Integer numberOfTraveler;

  public Trip id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Trip userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * The unique identifier of an user
   * @return userId
  */
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Trip title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the trip
   * @return title
  */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Trip creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * The creation date of the trip
   * @return creationDate
  */
  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public Trip departureDateTime(LocalDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
    return this;
  }

  /**
   * The datetime information of the departure
   * @return departureDateTime
  */
  public LocalDateTime getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(LocalDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  public Trip arrivalDateTime(LocalDateTime arrivalDateTime) {
    this.arrivalDateTime = arrivalDateTime;
    return this;
  }

  /**
   * The datetime information of the arrival
   * @return arrivalDateTime
  */
  public LocalDateTime getArrivalDateTime() {
    return arrivalDateTime;
  }

  public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
    this.arrivalDateTime = arrivalDateTime;
  }

  public Trip travelType(TravelTypeEnum travelType) {
    this.travelType = travelType;
    return this;
  }

  /**
   * The type of travel of the trip
   * @return travelType
  */
  public TravelTypeEnum getTravelType() {
    return travelType;
  }

  public void setTravelType(TravelTypeEnum travelType) {
    this.travelType = travelType;
  }

  public Trip travelNumber(String travelNumber) {
    this.travelNumber = travelNumber;
    return this;
  }

  /**
   * The travel number of the trip
   * @return travelNumber
  */
  public String getTravelNumber() {
    return travelNumber;
  }

  public void setTravelNumber(String travelNumber) {
    this.travelNumber = travelNumber;
  }

  public Trip travelDestinationCountry(String travelDestinationCountry) {
    this.travelDestinationCountry = travelDestinationCountry;
    return this;
  }

  /**
   * The destination country of the travel
   * @return travelDestinationCountry
  */
  public String getTravelDestinationCountry() {
    return travelDestinationCountry;
  }

  public void setTravelDestinationCountry(String travelDestinationCountry) {
    this.travelDestinationCountry = travelDestinationCountry;
  }

  public Trip travelOriginCountry(String travelOriginCountry) {
    this.travelOriginCountry = travelOriginCountry;
    return this;
  }

  /**
   * The origin country of the travel
   * @return travelOriginCountry
  */
  public String getTravelOriginCountry() {
    return travelOriginCountry;
  }

  public void setTravelOriginCountry(String travelOriginCountry) {
    this.travelOriginCountry = travelOriginCountry;
  }

  public Trip travelDestinationTown(String travelDestinationTown) {
    this.travelDestinationTown = travelDestinationTown;
    return this;
  }

  /**
   * The destination town of the travel
   * @return travelDestinationTown
  */
  public String getTravelDestinationTown() {
    return travelDestinationTown;
  }

  public void setTravelDestinationTown(String travelDestinationTown) {
    this.travelDestinationTown = travelDestinationTown;
  }

  public Trip travelOriginCountryTown(String travelOriginCountryTown) {
    this.travelOriginCountryTown = travelOriginCountryTown;
    return this;
  }

  /**
   * The origin town of the travel
   * @return travelOriginCountryTown
  */
  public String getTravelOriginCountryTown() {
    return travelOriginCountryTown;
  }

  public void setTravelOriginCountryTown(String travelOriginCountryTown) {
    this.travelOriginCountryTown = travelOriginCountryTown;
  }

  public Trip isBusinessTrip(String isBusinessTrip) {
    this.isBusinessTrip = isBusinessTrip;
    return this;
  }

  /**
   * Weither it is a business trip or not
   * @return isBusinessTrip
  */
  public String getIsBusinessTrip() {
    return isBusinessTrip;
  }

  public void setIsBusinessTrip(String isBusinessTrip) {
    this.isBusinessTrip = isBusinessTrip;
  }

  public Trip numberOfTraveler(Integer numberOfTraveler) {
    this.numberOfTraveler = numberOfTraveler;
    return this;
  }

  /**
   * Total number of travelers for the trip
   * @return numberOfTraveler
  */
  public Integer getNumberOfTraveler() {
    return numberOfTraveler;
  }

  public void setNumberOfTraveler(Integer numberOfTraveler) {
    this.numberOfTraveler = numberOfTraveler;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trip tripResponse = (Trip) o;
    return Objects.equals(this.id, tripResponse.id) &&
        Objects.equals(this.userId, tripResponse.userId) &&
        Objects.equals(this.title, tripResponse.title) &&
        Objects.equals(this.creationDate, tripResponse.creationDate) &&
        Objects.equals(this.departureDateTime, tripResponse.departureDateTime) &&
        Objects.equals(this.arrivalDateTime, tripResponse.arrivalDateTime) &&
        Objects.equals(this.travelType, tripResponse.travelType) &&
        Objects.equals(this.travelNumber, tripResponse.travelNumber) &&
        Objects.equals(this.travelDestinationCountry, tripResponse.travelDestinationCountry) &&
        Objects.equals(this.travelOriginCountry, tripResponse.travelOriginCountry) &&
        Objects.equals(this.travelDestinationTown, tripResponse.travelDestinationTown) &&
        Objects.equals(this.travelOriginCountryTown, tripResponse.travelOriginCountryTown) &&
        Objects.equals(this.isBusinessTrip, tripResponse.isBusinessTrip) &&
        Objects.equals(this.numberOfTraveler, tripResponse.numberOfTraveler);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, title, creationDate, departureDateTime, arrivalDateTime, travelType, travelNumber, travelDestinationCountry, travelOriginCountry, travelDestinationTown, travelOriginCountryTown, isBusinessTrip, numberOfTraveler);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TripResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    departureDateTime: ").append(toIndentedString(departureDateTime)).append("\n");
    sb.append("    arrivalDateTime: ").append(toIndentedString(arrivalDateTime)).append("\n");
    sb.append("    travelType: ").append(toIndentedString(travelType)).append("\n");
    sb.append("    travelNumber: ").append(toIndentedString(travelNumber)).append("\n");
    sb.append("    travelDestinationCountry: ").append(toIndentedString(travelDestinationCountry)).append("\n");
    sb.append("    travelOriginCountry: ").append(toIndentedString(travelOriginCountry)).append("\n");
    sb.append("    travelDestinationTown: ").append(toIndentedString(travelDestinationTown)).append("\n");
    sb.append("    travelOriginCountryTown: ").append(toIndentedString(travelOriginCountryTown)).append("\n");
    sb.append("    isBusinessTrip: ").append(toIndentedString(isBusinessTrip)).append("\n");
    sb.append("    numberOfTraveler: ").append(toIndentedString(numberOfTraveler)).append("\n");
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

