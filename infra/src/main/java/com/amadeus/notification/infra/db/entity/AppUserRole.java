package com.amadeus.notification.infra.db.entity;

public enum AppUserRole {
  ROLE_ADMIN, ROLE_CLIENT;

  public String getAuthority() {
    return name();
  }

}
