package com.java.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.mvc.model.User;
import com.java.spring.mvc.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response)  {
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		return model;
	}
	
	@RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		System.out.println("User Registration begin");
		userService.register(user);
		System.out.println("Registerd successfully");
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}
}
