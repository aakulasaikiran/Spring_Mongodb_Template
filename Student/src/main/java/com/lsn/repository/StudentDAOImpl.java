package com.lsn.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.lsn.domain.Student;
import com.lsn.repository.StudentDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class StudentDAOImpl implements StudentDAO {
	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void saveStudent(Student student) {
		mongoTemplate.save(student);
		System.out.println("Inserted Successfully");
	}

	public Student getStudent(int id) {

		Object sid = id;
		return mongoTemplate.findById(sid, Student.class);
	}

	public void createCollection() {
		if (!mongoTemplate.collectionExists(Student.class)) {
			mongoTemplate.createCollection(Student.class);
		}

	}

	public void dropCollection() {
		if (mongoTemplate.collectionExists(Student.class)) {
			mongoTemplate.dropCollection(Student.class);
		}

	}

	public void deleteStudent(String stname) {

		mongoTemplate.remove(new Query(Criteria.where("stname").is(stname)), Student.class);
		System.out.println("data deleted");

	}
	
	
	
	
	public void deleteStudent(Student student) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(student.getStid())), Student.class);
		System.out.println("data deleted");
		
	}


	public List<Student> getAllStudents() {

		return mongoTemplate.findAll(Student.class);
	}

	public void display(List<Student> list) {
		Iterator<Student> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

	public WriteResult updateStudent(String stname, String gender) {

		return mongoTemplate.updateFirst(new Query(Criteria.where("stname").is(stname)),
				Update.update("gender", gender), Student.class);
	}

	public Student getStudentmorethen(int id) {
		BasicDBObject query = new BasicDBObject("age",new BasicDBObject("$gte",id));
		System.out.println(query);
		 return mongoTemplate.findById(query,Student.class);
		/*CommandResult result = mongoTemplate.executeCommand("{\"age\" : { \"$gte\" : 2000}}");*/
		
		

	}

}
