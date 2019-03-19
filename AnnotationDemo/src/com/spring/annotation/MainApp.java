package com.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/Beans.xml");
		Student std = (Student)ctx.getBean("student");
		System.out.println(std);
	}
}
