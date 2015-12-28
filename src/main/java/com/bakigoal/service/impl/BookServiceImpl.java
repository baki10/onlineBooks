package com.bakigoal.service.impl;

import com.bakigoal.model.Author;
import com.bakigoal.model.UploadFile;
import com.bakigoal.repository.BookDao;
import com.bakigoal.model.Book;
import com.bakigoal.repository.SimpleDao;
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

  @Autowired
  private SimpleDao simpleDao;

  @Override
  public List<Book> getAllBooks() {
    return bookDao.getAll();
  }

  @Override
  public void createRandomBook() {
    bookDao.createRandomBook();
  }

  @Override
  public void createOrUpdateBook(Book book) {
    if (book == null) {
      return;
    }
    Author author = book.getAuthor();
    if (author != null) {
      if (author.isNew()) {
        simpleDao.save(author);
      } else {
        simpleDao.update(author);
      }
    }
    UploadFile photo = book.getPhoto();
    if (photo != null) {
      if (photo.isNew()) {
        simpleDao.save(photo);
      } else {
        simpleDao.update(photo);
      }
    }

    if (book.isNew()) {
      bookDao.save(book);
    } else {
      bookDao.update(book);
    }
  }

  @Override
  public Book findBookById(long bookId) {
    return bookDao.findById(bookId);
  }
}
