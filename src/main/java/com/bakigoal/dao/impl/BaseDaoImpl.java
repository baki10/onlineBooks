package com.bakigoal.dao.impl;

import com.bakigoal.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T> Entity
 * @param <P>
 * @author ilmir
 */
@Repository
public class BaseDaoImpl<T, P extends Serializable> implements BaseDao<T, P> {

  @Autowired
  private SessionFactory sessionFactory;

  public BaseDaoImpl() {
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  protected Class<T> entityClass;

  public BaseDaoImpl(Class clazz) {
    this.entityClass = clazz;
  }

  @Override
  public T save(T t) {
    getSession().save(t);
    return t;
  }

  @Override
  public T findById(P id) {
    return (T) getSession().get(entityClass, (Serializable) id);
  }

  @Override
  public Object findById(Class aClass, Serializable id) {
    return getSession().get(aClass, id);
  }

  @Override
  public T update(T t) {
    T merge = (T) getSession().merge(t);
    return merge;
  }

  @Override
  public void delete(T t) {
    T newT = (T) getSession().merge(t);
    getSession().delete(newT);
  }

  @Override
  public List getAll() {
    // Create a Hibernate query (HQL)
    Query query = getSession().createQuery("FROM " + entityClass.getSimpleName());

    // Retrieve all
    return query.list();
  }

}
