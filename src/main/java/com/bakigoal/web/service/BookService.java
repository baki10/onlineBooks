package com.bakigoal.web.service;

import com.bakigoal.dao.entity.Book;

import java.util.List;

/**
 * Created by ilmir on 17.12.15.
 */
public interface BookService {
  List<Book> getAllBooks();
  void createRandomBook();
}
