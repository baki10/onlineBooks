package com.bakigoal.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import java.util.List;

/**
 * Created by ilmir on 27.12.15.
 */
@Entity
public class Owner extends Person {
  private String address;
  private String city;
  private String telephone;

  private List<Book> books;

  @Column(name = "address")
  @NotEmpty
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Column(name = "city")
  @NotEmpty
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Column(name = "telephone")
  @NotEmpty
  @Digits(fraction = 0, integer = 10)
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
