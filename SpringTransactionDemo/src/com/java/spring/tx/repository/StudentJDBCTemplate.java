package com.java.spring.tx.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.java.spring.tx.bean.StudentMarks;

public class StudentJDBCTemplate implements StudentDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager pTransactionManager;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setpTransactionManager(PlatformTransactionManager pTransactionManager) {
		this.pTransactionManager = pTransactionManager;
	}
	
	public void create(int id, String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition transDef = new DefaultTransactionDefinition();
		
		System.out.println(transDef.getName());
		System.out.println(transDef.getTimeout());
		System.out.println("Transaction Behaviour " + transDef.getPropagationBehavior());
		System.out.println("Transaction Isolation " + transDef.getIsolationLevel());
		
		TransactionStatus transStatu = pTransactionManager.getTransaction(transDef);
		
		try {
			String sql ="insert into StudentTrans(id, name, age) values(?, ?, ?)";
			jdbcTemplate.update(sql, id, name, age);
			
			// Get the latest student id to be used in Marks table
			String queryForInt = "Select max(id) from StudentTrans";
			List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(queryForInt);
			
			String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
			jdbcTemplate.update(SQL3, 20, marks, year);
			
			System.out.println("Created Name = " + name + ", Age = " + age);
			pTransactionManager.commit(transStatu);
			
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			pTransactionManager.rollback(transStatu);
			throw e;
		}
	}

	public List<StudentMarks> listStudents() {
		String sql = "select * from StudentTrans, Marks where StudentTrans.id=Marks.sid";
		List<StudentMarks> listStudMarks = jdbcTemplate.query(sql, new StudentMarksMapper());
		return listStudMarks;
	}

}
