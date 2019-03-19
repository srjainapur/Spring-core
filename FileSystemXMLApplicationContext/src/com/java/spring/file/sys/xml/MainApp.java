package com.java.spring.file.sys.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("D:/WorkSpaces_Folder/Spring_Spring_Boot/FileSystemXMLApplicationContext/src/resources/spring.xml");
		HelloWorld world = (HelloWorld)context.getBean("helloWorld");
		System.out.println(world.getMessage());
	}
}
