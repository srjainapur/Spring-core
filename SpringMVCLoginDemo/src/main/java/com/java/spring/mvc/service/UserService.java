package com.java.spring.mvc.service;

import com.java.spring.mvc.model.Login;
import com.java.spring.mvc.model.User;

public interface UserService {
	void register(User user);
	User validateUser(Login login);
}
