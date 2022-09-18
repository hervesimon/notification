package com.amadeus.api.notification.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Notification data for an user
 */

@Schema(name = "Notification", description = "Notification data for an user")
public class NotificationJson {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("description")
  private String description;

    @JsonProperty("creationDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime creationDateTime;

  public NotificationJson id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identification for a notification
   * @return id
  */
  
  @Schema(name = "id", description = "Unique identification for a notification", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public NotificationJson description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the notification
   * @return description
  */
  
  @Schema(name = "description", description = "The description of the notification", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NotificationJson creationDateTime(OffsetDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
    return this;
  }

  /**
   * The creation datetime of the notification
   * @return creationDateTime
  */
  
  @Schema(name = "creationDateTime", description = "The creation datetime of the notification", required = false)
  public OffsetDateTime getCreationDateTime() {
    return creationDateTime;
  }

  public void setCreationDateTime(OffsetDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationJson notification = (NotificationJson) o;
    return Objects.equals(this.id, notification.id) &&
        Objects.equals(this.description, notification.description) &&
        Objects.equals(this.creationDateTime, notification.creationDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, creationDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    creationDateTime: ").append(toIndentedString(creationDateTime)).append("\n");
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

