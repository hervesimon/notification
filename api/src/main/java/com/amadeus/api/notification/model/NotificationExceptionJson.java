package com.amadeus.api.notification.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * NotificationException
 */

public class NotificationExceptionJson {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  @JsonProperty("contextParams")
  private Object contextParams;

  public NotificationExceptionJson code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  
  @Schema(name = "code", required = false)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public NotificationExceptionJson message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", required = false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public NotificationExceptionJson contextParams(Object contextParams) {
    this.contextParams = contextParams;
    return this;
  }

  /**
   * Get contextParams
   * @return contextParams
  */
  
  @Schema(name = "contextParams", required = false)
  public Object getContextParams() {
    return contextParams;
  }

  public void setContextParams(Object contextParams) {
    this.contextParams = contextParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationExceptionJson notificationException = (NotificationExceptionJson) o;
    return Objects.equals(this.code, notificationException.code) &&
        Objects.equals(this.message, notificationException.message) &&
        Objects.equals(this.contextParams, notificationException.contextParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, contextParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationException {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    contextParams: ").append(toIndentedString(contextParams)).append("\n");
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

