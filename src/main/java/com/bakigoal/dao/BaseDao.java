package com.bakigoal.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @author ilmir
 */
public interface BaseDao<T,  P extends Serializable> {

  public T save(T t);

  public T findById(P id);

  public Object findById(Class aClass, Serializable id);

  public T update(T t);

  public void delete(T t);

  public List<T> getAll();
}
