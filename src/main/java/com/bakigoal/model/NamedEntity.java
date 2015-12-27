package com.bakigoal.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by ilmir on 27.12.15.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

  private String name;

  @Column(name = "name")
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.getName();
  }

}

