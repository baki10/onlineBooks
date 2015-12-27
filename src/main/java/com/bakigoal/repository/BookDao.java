package com.bakigoal.repository;

import com.bakigoal.model.Book;

/**
 * Created by ilmir on 17.12.15.
 */
public interface BookDao extends BaseDao<Book, Long> {
  void createRandomBook();
}
