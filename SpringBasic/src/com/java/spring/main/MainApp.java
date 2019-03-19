package com.java.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.bean.Employee;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"/resources/Beans.xml", "/resources/Address.xml"});//new ClassPathXmlApplicationContext("/resources/Beans.xml");
		Employee emp = (Employee)context.getBean("employee");
		System.out.println(emp);
	}
}
