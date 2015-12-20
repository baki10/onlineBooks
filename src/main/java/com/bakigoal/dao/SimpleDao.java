package com.bakigoal.dao;

/**
 * Created by ilmir on 17.12.15.
 */
public interface SimpleDao<T, P> extends BaseDao {
  void setEntityClass(Class c);
}
