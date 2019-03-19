package com.java.spring.bean.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
	public static void main(String[] args) {
		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("resources/spring.xml"));
		HelloWorld hWorld = (HelloWorld)beanFactory.getBean("helloWorld");
		System.out.println(hWorld.getMessage());
	}
}
