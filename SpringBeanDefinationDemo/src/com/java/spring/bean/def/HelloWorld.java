package com.java.spring.bean.def;

public class HelloWorld {
	public HelloWorld() {
		System.out.println("HelloWOrld Constructor !!!!");
	}
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void init() {
		System.out.println("HelloWorld init() method");
	}
	
	public void destory() {
		System.out.println("HelloWorld destroy method");
	}
}
