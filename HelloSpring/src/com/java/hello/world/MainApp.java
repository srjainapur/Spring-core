package com.java.hello.world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/Spring.xml");
		HelloWorld hWorld = (HelloWorld)context.getBean("helloWorld");
		System.out.println(hWorld.getMessage()); 
		
	}
}
