package com.bakigoal.web.service;

import com.bakigoal.dao.entity.UploadFile;

import java.util.List;

/**
 * Created by ilmir on 18.12.15.
 */
public interface UploadFileService {
  void save(UploadFile uploadFile);

  List<UploadFile> getAll();

  UploadFile getById(Long id);
}
