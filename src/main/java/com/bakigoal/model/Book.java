package com.bakigoal.model;

import com.bakigoal.util.FieldSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by ilmir on 17.12.15.
 */
@Entity
public class Book extends BaseEntity {

  private String title;         //название
  private String published;     //год публикации
  private Author author;        //автор
  private String description;   //описание
  private UploadFile photo;     //обложка

  public Book(String title, String published) {
    this.title = title;
    this.published = published;
  }

  public Book() {
  }

  @Column(length = FieldSize.TITLE)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(length = FieldSize.YEAR)
  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  @ManyToOne
  @JoinColumn(name = "author_id")
  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Column(length = FieldSize.DESCR)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @ManyToOne
  @JoinColumn(name = "photo_id")
  public UploadFile getPhoto() {
    return photo;
  }

  public void setPhoto(UploadFile photo) {
    this.photo = photo;
  }
}
