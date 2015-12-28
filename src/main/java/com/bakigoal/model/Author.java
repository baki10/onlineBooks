package com.bakigoal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by ilmir on 27.12.15.
 */
@Entity
public class Author extends NamedEntity {

  private List<Book> books;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
