package com.java.spring.tx;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.tx.bean.StudentMarks;
import com.java.spring.tx.repository.StudentJDBCTemplate;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/Beans.xml");
		StudentJDBCTemplate studJdbcTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		
		System.out.println("------Records creation--------");
		studJdbcTemplate.create(70, "Zara", 11, 99, 2010);
		studJdbcTemplate.create(80, "Nuha", 20, 97, 2010);
		studJdbcTemplate.create(90, "Ayan", 25, 100, 2011);

		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studJdbcTemplate.listStudents();

		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
	}
}
