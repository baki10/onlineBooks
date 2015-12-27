package com.bakigoal.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by ilmir on 27.12.15.
 */
@MappedSuperclass
public class Person extends BaseEntity {

  protected String firstName;
  protected String lastName;

  @Column(name = "first_name")
  @NotEmpty
  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last_name")
  @NotEmpty
  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
