package com.amadeus.notification.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * UserCredential
 */
public class UserCredential {

  private String username;

  private String password;

  private List<UserRole> appUserRoles;

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

    public String[] getAppUserRoles() {
      if(null != appUserRoles){
          return appUserRoles.stream().map(userRole -> userRole.getAuthority()).toArray(String[]::new);
      }
      return null;
    }

    public void setAppUserRoles(List<UserRole> appUserRoles) {
        this.appUserRoles = appUserRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserCredential that = (UserCredential) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(appUserRoles, that.appUserRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, appUserRoles);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserCredential{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", appUserRoles=").append(appUserRoles);
        sb.append('}');
        return sb.toString();
    }
}

