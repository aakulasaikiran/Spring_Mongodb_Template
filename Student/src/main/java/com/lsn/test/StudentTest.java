package com.lsn.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.lsn.domain.Student;
import com.lsn.repository.StudentDAO;
import com.lsn.repository.StudentDAOImpl;

public class StudentTest {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");

		StudentDAO stdao = context.getBean(StudentDAOImpl.class);
		Student student=new Student(5, "akshitha", "fmale", 2500);
		
		  /*stdao.saveStudent(new Student(5, "akshitha", "fmale", 2500));
		  System.out.println("Student Data: " + stdao.getStudent(3).toString());*/
		 

		/*
		 * stdao.createCollection(); System.out.println("collecetion created");
		 * 
		 * stdao.dropCollection(); System.out.println("Student Collection Dropped");
		 * 
		 * stdao.deleteStudent("saikiran");
		 * 
		 * System.out.println("display All Stdent Details :");
		 * System.out.println(stdao.getAllStudents()); System.out.println();
		 * stdao.display(stdao.getAllStudents());
		 * 
		 * System.out.println("Before Updation :"); stdao.updateStudent("saikiran",
		 * "male"); stdao.display(stdao.getAllStudents());
		 * 
		 * System.out.println("after Updation :"); stdao.updateStudent("nishanth",
		 * "male");
		 * 
		 * stdao.display(stdao.getAllStudents());
		 * 
		 * BasicQuery query = new BasicQuery("{stid:1,stname:saikiran}");
		 */

		System.out.println(stdao.getStudentmorethen(2000));
		stdao.deleteStudent(student);

	}

}
