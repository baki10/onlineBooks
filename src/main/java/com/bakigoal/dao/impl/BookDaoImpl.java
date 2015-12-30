package com.bakigoal.dao.impl;

import com.bakigoal.dao.BookDao;
import com.bakigoal.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Created by ilmir on 17.12.15.
 */
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book, Long> implements BookDao {

  public BookDaoImpl() {
    super(Book.class);
  }

  @Override
  public void createRandomBook() {
    save(new Book("Hibernate " + new Random().nextInt(100), "2014"));
  }

}
