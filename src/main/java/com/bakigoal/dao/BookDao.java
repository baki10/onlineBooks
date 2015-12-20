package com.bakigoal.dao;

import com.bakigoal.dao.entity.Book;

/**
 * Created by ilmir on 17.12.15.
 */
public interface BookDao extends BaseDao<Book, Long> {
  void createRandomBook();
}
