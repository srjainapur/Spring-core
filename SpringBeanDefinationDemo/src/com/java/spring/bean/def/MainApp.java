package com.java.spring.bean.def;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/Spring.xml");
		HelloWorld world = (HelloWorld)context.getBean("helloWorld");
		System.out.println(world.getMessage());
		context.close();
	}
}
