package com.bakigoal.service.impl;

import com.bakigoal.dao.SimpleDao;
import com.bakigoal.model.User;
import com.bakigoal.model.UserRole;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by ilmir on 30.12.15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private SimpleDao simpleDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    simpleDao.save(user);
  }

  @Override
  public List<User> getAll() {
    simpleDao.setEntityClass(User.class);
    return simpleDao.getAll();
  }

  @Override
  public User getByUsername(String username) {
    return (User) simpleDao.findById(User.class, username);
  }

}
