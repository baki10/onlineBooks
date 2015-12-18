package com.bakigoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by ilmir on 17.12.15.
 */
@Entity
public class Book {
  @GeneratedValue
  @Id
  private Integer id;
  private String title;
  @Temporal(TemporalType.DATE)
  private Date published;

  public Book(String title, Date published) {
    this.title = title;
    this.published = published;
  }

  public Book() {
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Book");
    sb.append("{id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", published=").append(published);
    sb.append('}');
    return sb.toString();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getPublished() {
    return published;
  }

  public void setPublished(Date published) {
    this.published = published;
  }
}
