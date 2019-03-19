package com.spring.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
