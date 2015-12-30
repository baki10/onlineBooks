package com.bakigoal.service;

import com.bakigoal.model.UploadFile;
import com.bakigoal.model.User;

import java.util.List;

/**
 * Created by ilmir on 18.12.15.
 */
public interface UserService {
  void save(User user);

  List<User> getAll();

  User getByUsername(String username);
}
