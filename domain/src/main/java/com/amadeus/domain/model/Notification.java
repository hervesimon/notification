package com.amadeus.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Notification data for an user
 */

public class Notification {

  private Long id;

  private String description;

  private LocalDateTime creationDateTime;

  public Notification id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identification for a notification
   * @return id
  */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Notification description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the notification
   * @return description
  */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Notification creationDateTime(LocalDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
    return this;
  }

  /**
   * The creation datetime of the notification
   * @return creationDateTime
  */
  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  public void setCreationDateTime(LocalDateTime creationDateTime) {
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
    Notification notification = (Notification) o;
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
        final StringBuffer sb = new StringBuffer("Notification{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", creationDateTime='").append(creationDateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

