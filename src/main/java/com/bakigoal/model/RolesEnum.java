package com.bakigoal.model;

/**
 * Created by ilmir on 30.12.15.
 */
public enum RolesEnum {
  ADMIN("Administrator"), USER("User");

  private String role;

  RolesEnum(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return this.role;
  }
}
