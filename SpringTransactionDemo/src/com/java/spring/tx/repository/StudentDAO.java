package com.java.spring.tx.repository;

import java.util.List;

import javax.sql.DataSource;

import com.java.spring.tx.bean.StudentMarks;

public interface StudentDAO {
	
	/** This is the method to be used to initialize database resources ie. connection.*/
	public void setDataSource(DataSource ds);
	
	/** This is the method to be used to create a record in the Student and Marks tables.*/
	public void create(int id, String name, Integer age, Integer marks, Integer year);
	
	/** This is the method to be used to list down all the records from the Student and Marks tables. */
	public List<StudentMarks> listStudents();
}
