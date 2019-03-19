package com.spring.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resource/Spring.xml");
		HelloWorld h = (HelloWorld)context.getBean("helloWorld");
		h.setMessage("Object h message");
		
		System.out.println("h Message : " + h.getMessage());
		
		HelloWorld i = (HelloWorld)context.getBean("helloWorld");
		System.out.println("i message : " + i.getMessage());
	}
}
