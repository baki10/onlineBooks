package com.bakigoal.dao.impl;

import com.bakigoal.dao.UploadFileDAO;
import com.bakigoal.model.UploadFile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

  @Override
  public List<UploadFile> getAll() {
    return (List<UploadFile>) sessionFactory.getCurrentSession().createQuery("from UploadFile").list();
  }

  @Override
  public UploadFile getById(Long id) {
    return (UploadFile) sessionFactory.getCurrentSession().get(UploadFile.class, id);
  }
}
