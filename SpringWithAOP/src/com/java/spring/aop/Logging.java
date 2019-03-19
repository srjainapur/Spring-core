package com.java.spring.aop;

public class Logging {
	
	/** 
     * This is the method which I would like to execute
     * before a selected method execution.
     */
	public void beforeAdvice() {
		System.out.println("Going to set up student profile");
	}
	
	/** 
     * This is the method which I would like to execute
     * after a selected method execution.
     */
	public void afterAdvice() {
		System.out.println("Student profile set up completed");
	}
	
	/** 
     * This is the method which I would like to execute
     * when any method returns.
     */
	public void afterReturningAdvice(Object returnVal) {
		System.out.println("Returning : " + returnVal.toString());
	}
	
	/**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
}
