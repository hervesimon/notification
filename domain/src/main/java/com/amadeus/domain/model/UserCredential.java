package com.amadeus.domain.model;

import java.util.Objects;

/**
 * UserCredential
 */
public class UserCredential {

  private String username;

  private String password;

  public UserCredential username(String username) {
    this.username = username;
    return this;
  }

  /**
   * The username of the user
   * @return username
  */
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserCredential password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The password of the user not encrypted
   * @return password
  */
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
    UserCredential userCredential = (UserCredential) o;
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

