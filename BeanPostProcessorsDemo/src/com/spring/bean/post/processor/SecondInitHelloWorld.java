package com.spring.bean.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SecondInitHelloWorld implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SecondInitHelloWorld BeforeInitialization : " + beanName);
		return bean; // you can return any other object as well
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SecondInitHelloWorld AfterInitialization : " + beanName);
		return bean; // you can return any other object as well
	}
}
