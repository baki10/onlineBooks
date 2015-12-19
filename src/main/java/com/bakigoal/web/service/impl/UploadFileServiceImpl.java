package com.bakigoal.web.service.impl;

import com.bakigoal.dao.UploadFileDAO;
import com.bakigoal.model.UploadFile;
import com.bakigoal.web.service.UploadFileService;
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
  private UploadFileDAO uploadFileDAO;

  @Override
  public void save(UploadFile uploadFile) {
    logger.log(Level.INFO, "Start saving file to db");
    uploadFileDAO.save(uploadFile);
    logger.log(Level.INFO, "Finish saving file to db");
  }

  @Override
  public List<UploadFile> getAll() {
    return uploadFileDAO.getAll();
  }

  @Override
  public UploadFile getById(Long id) {
    return uploadFileDAO.getById(id);
  }
}
