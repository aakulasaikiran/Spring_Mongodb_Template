package com.lsn.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lsn.domain.Employee;
import com.lsn.repository.EmployeeDAO;
import com.lsn.repository.EmployeeDAOImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");
		EmployeeDAO dao = context.getBean(EmployeeDAOImpl.class);
		/*
		 * List<Employee> employees = (List<Employee>) dao.getEmployee("A");
		 * System.out.println(employees);
		 */
		// System.out.println(dao.getEmployee("A"));
		// System.out.println(employees);
		dao.getEmployee("A");
		
	}

}
