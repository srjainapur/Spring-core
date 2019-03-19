package com.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.spring.mvc.dao.UserDao;
import com.java.spring.mvc.model.Login;
import com.java.spring.mvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
