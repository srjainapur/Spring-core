package com.java.spring.dec.tx;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.dec.tx.bean.StudentMarks;
import com.java.spring.dec.tx.repo.StudentDAO;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("resources/Beans.xml");

      StudentDAO studentJDBCTemplate = (StudentDAO)context.getBean("studentJDBCTemplate");
      
      System.out.println("------Records creation--------" );
      studentJDBCTemplate.create(101, "Zara", 11, 99, 2010);
      studentJDBCTemplate.create(102, "Nuha", 20, 97, 2010);
      studentJDBCTemplate.create(103, "Ayan", 25, 100, 2011);

      System.out.println("------Listing all the records--------" );
      List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
      
      for (StudentMarks record : studentMarks) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.print(", Marks : " + record.getMarks());
         System.out.print(", Year : " + record.getYear());
         System.out.println(", Age : " + record.getAge());
      }
   }
}
