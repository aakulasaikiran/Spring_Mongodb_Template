package com.lsn.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.lsn.domain.Student;
import com.mongodb.CommandResult;
import com.mongodb.WriteResult;

public interface StudentDAO {

	public void saveStudent(Student student);

	public Student getStudent(int id);

	public void createCollection();

	public void dropCollection();

	public void deleteStudent(String stname);
	public void deleteStudent(Student student);

	public List<Student> getAllStudents();

	public void display(List<Student> list);

	public WriteResult updateStudent(String stname, String gender);

	public Student getStudentmorethen(int id);

}
