package com.java.spring.file.sys.xml;

public class HelloWorld {
	private String message;
	
	public HelloWorld() {
		System.out.println("HelloWorld COnstructor !!!!");
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
