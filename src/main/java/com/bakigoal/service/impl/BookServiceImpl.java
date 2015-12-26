package com.bakigoal.service.impl;

import com.bakigoal.dao.BookDao;
import com.bakigoal.dao.entity.Book;
import com.bakigoal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ilmir on 17.12.15.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

  protected static Logger logger = Logger.getLogger("BookService");

  @Autowired
  private BookDao bookDao;

  @Override
  public List<Book> getAllBooks() {
    return bookDao.getAll();
  }

  @Override
  public void createRandomBook() {
    bookDao.createRandomBook();
  }
}
