package com.bakigoal.dao.impl;

import com.bakigoal.dao.BookDao;
import com.bakigoal.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ilmir on 17.12.15.
 */
@Repository
public class BookDaoImpl implements BookDao {

  protected static Logger logger = Logger.getLogger("BookDao");

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Book> getAllBooks() {
    logger.log(Level.INFO, "Retrieving all books");

    // Retrieve session from Hibernate
    Session session = sessionFactory.getCurrentSession();

    // Create a Hibernate query (HQL)
    Query query = session.createQuery("FROM  Book");

    // Retrieve all
    return  query.list();
  }

  @Override
  public void createRandomBook() {
    Session session = sessionFactory.getCurrentSession();
    session.save(new Book("Hibernate " + new Random().nextInt(100), new Date()));
  }

  /**
   * Adds a new book
   */
  public void add(Book book) {
    logger.log(Level.INFO, "Adding new book");

    // Retrieve session from Hibernate
    Session session = sessionFactory.getCurrentSession();

    // Save
    session.save(book);
  }
}
