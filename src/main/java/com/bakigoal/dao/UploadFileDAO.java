package com.bakigoal.dao;

import com.bakigoal.model.UploadFile;

import java.util.List;

/**
 * Created by ilmir on 18.12.15.
 */
public interface UploadFileDAO {
  void save(UploadFile uploadFile);

  List<UploadFile> getAll();

  UploadFile getById(Long id);
}
