package com.java.spring.bean;

public class ParentBean {
	
	public ParentBean() {
		System.out.println("Default ParentBean Constructor");
	}

	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
