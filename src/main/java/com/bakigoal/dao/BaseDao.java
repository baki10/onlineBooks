package com.bakigoal.dao;

import java.util.List;

/**
 * @param <T>
 * @author ilmir
 */
public interface BaseDao<T, P> {

  public T save(T t);

  public T findById(P id);

  public T update(T t);

  public void delete(T t);

  public List<T> getAll();
}
