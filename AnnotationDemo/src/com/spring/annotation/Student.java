package com.spring.annotation;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private int age;
	private String name;
	private String gender;
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	@Required
	public void setAge(int age) {
		this.age = age;
	}
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	
	@Required
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
}
