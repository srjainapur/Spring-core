package com.java.spring.mvc.dao;

import com.java.spring.mvc.model.Login;
import com.java.spring.mvc.model.User;

public interface UserDao {

	void register(User user);

	User validateUser(Login login);
}