package com.bakigoal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ilmir on 29.12.15.
 */
@Entity
@Table(name = "user_roles")
public class UserRole{

  private Integer userRoleId;
  private User user;
  private String role;

  public UserRole() {
  }

  public UserRole(User user, String role) {
    this.user = user;
    this.role = role;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_role_id",
      unique = true, nullable = false)
  public Integer getUserRoleId() {
    return this.userRoleId;
  }

  public void setUserRoleId(Integer userRoleId) {
    this.userRoleId = userRoleId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "username", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Column(name = "role", nullable = false, length = 45)
  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
