package com.java.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.mvc.model.Login;
import com.java.spring.mvc.model.User;
import com.java.spring.mvc.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("login", new Login());
		return model;
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
		User user = userService.validateUser(login);
		ModelAndView model = null;
		
		if(user != null) {
			model = new ModelAndView("welcome");
			model.addObject("firstname", user.getFirstname());
		} else {
			model = new ModelAndView("login");
			model.addObject("message", "Username or Password is wrong!!");
		}
		
		return model;
	}
}
