package com.bakigoal.service;

import com.bakigoal.model.Book;

import java.util.List;

/**
 * Created by ilmir on 17.12.15.
 */
public interface BookService {
  List<Book> getAllBooks();
  void createRandomBook();

  void createOrUpdateBook(Book book);

  Book findBookById(long bookId);
}
