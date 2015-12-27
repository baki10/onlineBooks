package com.bakigoal.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Created by ilmir on 17.12.15.
 */
@MappedSuperclass
public abstract class BaseEntity implements Identified{
  private Long id;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Transient
  public boolean isNew(){
    return this.id == null;
  }

}
