package com.amadeus.api.notification.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UserCredential
 */
@Schema(name = "UserCredential", description = "User information to log in the system")
public class UserCredentialJson {

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  public UserCredentialJson username(String username) {
    this.username = username;
    return this;
  }

  /**
   * The username of the user
   * @return username
  */
  @NotNull 
  @Schema(name = "username", description = "The username of the user", required = true)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserCredentialJson password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The password of the user not encrypted
   * @return password
  */
  @NotNull 
  @Schema(name = "password", description = "The password of the user not encrypted", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCredentialJson userCredential = (UserCredentialJson) o;
    return Objects.equals(this.username, userCredential.username) &&
        Objects.equals(this.password, userCredential.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCredential {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

