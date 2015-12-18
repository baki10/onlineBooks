package com.bakigoal.dao;

import com.bakigoal.model.Book;

import java.util.List;

/**
 * Created by ilmir on 17.12.15.
 */
public interface BookDao {
  List<Book> getAllBooks();
  void createRandomBook();
}
