package com.amadeus.api.notification.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The informartions for a user&#39;s trip.
 */

@Schema(name = "TripResponse", description = "The informartions for a user's trip.")
public class TripResponseJson {

  @JsonProperty("id")
  private String id;

  @JsonProperty("userId")
  private Long userId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("creationDate")
  private String creationDate;

  @JsonProperty("departureDateTime")
  private String departureDateTime;

  @JsonProperty("arrivalDateTime")
  private String arrivalDateTime;

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

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TravelTypeEnum fromValue(String value) {
      for (TravelTypeEnum b : TravelTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("travelType")
  private TravelTypeEnum travelType;

  @JsonProperty("travelNumber")
  private String travelNumber;

  @JsonProperty("travelDestinationCountry")
  private String travelDestinationCountry;

  @JsonProperty("travelOriginCountry")
  private String travelOriginCountry;

  @JsonProperty("travelDestinationTown")
  private String travelDestinationTown;

  @JsonProperty("travelOriginCountryTown")
  private String travelOriginCountryTown;

  @JsonProperty("isBusinessTrip")
  private String isBusinessTrip;

  @JsonProperty("numberOfTraveler")
  private BigDecimal numberOfTraveler;

  public TripResponseJson id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TripResponseJson userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * The unique identifier of an user
   * @return userId
  */
  
  @Schema(name = "userId", description = "The unique identifier of an user", required = false)
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public TripResponseJson title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the trip
   * @return title
  */
  
  @Schema(name = "title", description = "The title of the trip", required = false)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TripResponseJson creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * The creation date of the trip
   * @return creationDate
  */
  
  @Schema(name = "creationDate", description = "The creation date of the trip", required = false)
  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public TripResponseJson departureDateTime(String departureDateTime) {
    this.departureDateTime = departureDateTime;
    return this;
  }

  /**
   * The datetime information of the departure
   * @return departureDateTime
  */
  
  @Schema(name = "departureDateTime", description = "The datetime information of the departure", required = false)
  public String getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(String departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  public TripResponseJson arrivalDateTime(String arrivalDateTime) {
    this.arrivalDateTime = arrivalDateTime;
    return this;
  }

  /**
   * The datetime information of the arrival
   * @return arrivalDateTime
  */
  
  @Schema(name = "arrivalDateTime", description = "The datetime information of the arrival", required = false)
  public String getArrivalDateTime() {
    return arrivalDateTime;
  }

  public void setArrivalDateTime(String arrivalDateTime) {
    this.arrivalDateTime = arrivalDateTime;
  }

  public TripResponseJson travelType(TravelTypeEnum travelType) {
    this.travelType = travelType;
    return this;
  }

  /**
   * The type of travel of the trip
   * @return travelType
  */
  
  @Schema(name = "travelType", description = "The type of travel of the trip", required = false)
  public TravelTypeEnum getTravelType() {
    return travelType;
  }

  public void setTravelType(TravelTypeEnum travelType) {
    this.travelType = travelType;
  }

  public TripResponseJson travelNumber(String travelNumber) {
    this.travelNumber = travelNumber;
    return this;
  }

  /**
   * The travel number of the trip
   * @return travelNumber
  */
  
  @Schema(name = "travelNumber", description = "The travel number of the trip", required = false)
  public String getTravelNumber() {
    return travelNumber;
  }

  public void setTravelNumber(String travelNumber) {
    this.travelNumber = travelNumber;
  }

  public TripResponseJson travelDestinationCountry(String travelDestinationCountry) {
    this.travelDestinationCountry = travelDestinationCountry;
    return this;
  }

  /**
   * The destination country of the travel
   * @return travelDestinationCountry
  */
  
  @Schema(name = "travelDestinationCountry", description = "The destination country of the travel", required = false)
  public String getTravelDestinationCountry() {
    return travelDestinationCountry;
  }

  public void setTravelDestinationCountry(String travelDestinationCountry) {
    this.travelDestinationCountry = travelDestinationCountry;
  }

  public TripResponseJson travelOriginCountry(String travelOriginCountry) {
    this.travelOriginCountry = travelOriginCountry;
    return this;
  }

  /**
   * The origin country of the travel
   * @return travelOriginCountry
  */
  
  @Schema(name = "travelOriginCountry", description = "The origin country of the travel", required = false)
  public String getTravelOriginCountry() {
    return travelOriginCountry;
  }

  public void setTravelOriginCountry(String travelOriginCountry) {
    this.travelOriginCountry = travelOriginCountry;
  }

  public TripResponseJson travelDestinationTown(String travelDestinationTown) {
    this.travelDestinationTown = travelDestinationTown;
    return this;
  }

  /**
   * The destination town of the travel
   * @return travelDestinationTown
  */
  
  @Schema(name = "travelDestinationTown", description = "The destination town of the travel", required = false)
  public String getTravelDestinationTown() {
    return travelDestinationTown;
  }

  public void setTravelDestinationTown(String travelDestinationTown) {
    this.travelDestinationTown = travelDestinationTown;
  }

  public TripResponseJson travelOriginCountryTown(String travelOriginCountryTown) {
    this.travelOriginCountryTown = travelOriginCountryTown;
    return this;
  }

  /**
   * The origin town of the travel
   * @return travelOriginCountryTown
  */
  
  @Schema(name = "travelOriginCountryTown", description = "The origin town of the travel", required = false)
  public String getTravelOriginCountryTown() {
    return travelOriginCountryTown;
  }

  public void setTravelOriginCountryTown(String travelOriginCountryTown) {
    this.travelOriginCountryTown = travelOriginCountryTown;
  }

  public TripResponseJson isBusinessTrip(String isBusinessTrip) {
    this.isBusinessTrip = isBusinessTrip;
    return this;
  }

  /**
   * Weither it is a business trip or not
   * @return isBusinessTrip
  */
  
  @Schema(name = "isBusinessTrip", description = "Weither it is a business trip or not", required = false)
  public String getIsBusinessTrip() {
    return isBusinessTrip;
  }

  public void setIsBusinessTrip(String isBusinessTrip) {
    this.isBusinessTrip = isBusinessTrip;
  }

  public TripResponseJson numberOfTraveler(BigDecimal numberOfTraveler) {
    this.numberOfTraveler = numberOfTraveler;
    return this;
  }

  /**
   * Total number of travelers for the trip
   * @return numberOfTraveler
  */
  @Valid 
  @Schema(name = "numberOfTraveler", description = "Total number of travelers for the trip", required = false)
  public BigDecimal getNumberOfTraveler() {
    return numberOfTraveler;
  }

  public void setNumberOfTraveler(BigDecimal numberOfTraveler) {
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
    TripResponseJson tripResponse = (TripResponseJson) o;
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

