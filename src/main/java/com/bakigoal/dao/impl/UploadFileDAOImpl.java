package com.bakigoal.dao.impl;

import com.bakigoal.dao.UploadFileDAO;
import com.bakigoal.model.UploadFile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ilmir on 18.12.15.
 */
@Repository
public class UploadFileDAOImpl implements UploadFileDAO {
  @Autowired
  private SessionFactory sessionFactory;

  public UploadFileDAOImpl() {
  }

  public UploadFileDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void save(UploadFile uploadFile) {
    sessionFactory.getCurrentSession().save(uploadFile);
  }
}
