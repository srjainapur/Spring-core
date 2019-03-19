package com.java.spring.dec.tx.repo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.java.spring.dec.tx.bean.StudentMarks;

public class StudentJDBCTemplate implements StudentDAO {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<StudentMarks> listStudents() {
		String SQL = "select * from StudentTrans, Marks where StudentTrans.id = Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplate.query(SQL, new StudentMarksMapper());

		return studentMarks;
	}
	
	public void create(int id, String name, Integer age, Integer marks, Integer year) {
		try {
			String SQL1 = "insert into StudentTrans (id, name, age) values (?, ?, ?)";
			jdbcTemplate.update(SQL1, id, name, age);

			// Get the latest student id to be used in Marks table
			//String SQL2 = "select max(id) from Student";
			//int sid = jdbcTemplate.queryForInt(SQL2);

			String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
			jdbcTemplate.update(SQL3, id, marks, year);
			System.out.println("Created Name = " + name + ", Age = " + age);

			// to simulate the exception.
			//throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}
}
