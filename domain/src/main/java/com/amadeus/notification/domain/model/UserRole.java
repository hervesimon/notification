package com.amadeus.notification.domain.model;

public enum UserRole {
    ROLE_ADMIN, ROLE_CLIENT;
    public String getAuthority() {
        return name();
    }
}
