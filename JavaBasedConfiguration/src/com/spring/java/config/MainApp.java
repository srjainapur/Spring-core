package com.spring.java.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HelloWorld h = (HelloWorld)ctx.getBean("helloWorld");
		h.setMessage("Java Based Configuration");
		h.getMessage();
	}
}
