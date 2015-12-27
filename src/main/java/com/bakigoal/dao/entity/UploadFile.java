package com.bakigoal.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ilmir on 18.12.15.
 */
@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile extends BaseEntity {

  private String fileName;
  private byte[] data;

  @Column(name = "FILE_NAME")
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Column(name = "FILE_DATA")
  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}
