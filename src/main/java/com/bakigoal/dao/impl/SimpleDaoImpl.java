package com.bakigoal.dao.impl;

import com.bakigoal.dao.SimpleDao;
import org.springframework.stereotype.Repository;

/**
 * Created by ilmir on 20.12.15.
 */
@Repository
public class SimpleDaoImpl extends BaseDaoImpl implements SimpleDao {

  @Override
  public void setEntityClass(Class c) {
    entityClass = c;
  }
}
