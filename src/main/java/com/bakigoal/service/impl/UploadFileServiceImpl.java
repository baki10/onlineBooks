package com.bakigoal.service.impl;

import com.bakigoal.dao.SimpleDao;
import com.bakigoal.model.UploadFile;
import com.bakigoal.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ilmir on 18.12.15.
 */
@Service
@Transactional
public class UploadFileServiceImpl implements UploadFileService {

  protected static Logger logger = Logger.getLogger("UploadFileService");

  @Autowired
  private SimpleDao simpleDao;

  @Override
  public void save(UploadFile uploadFile) {
    logger.log(Level.INFO, "Start saving file to db");
    simpleDao.save(uploadFile);
    logger.log(Level.INFO, "Finish saving file to db");
  }

  @Override
  public List<UploadFile> getAll() {
    simpleDao.setEntityClass(UploadFile.class);
    return simpleDao.getAll();
  }

  @Override
  public UploadFile getById(Long id) {
    return (UploadFile) simpleDao.findById(UploadFile.class, id);
  }
}
