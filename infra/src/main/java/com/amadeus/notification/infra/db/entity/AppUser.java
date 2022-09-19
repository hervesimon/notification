package com.amadeus.notification.infra.db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "app_user")
@Data
@NoArgsConstructor
public class AppUser {

  @Id
  private Integer id;

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Size(min = 8, message = "Minimum password length: 8 characters")
  private String password;

  List<AppUserRole> appUserRoles;

}
