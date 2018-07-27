package com.lsn.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.lsn.domain.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;

public class EmployeeDAOImpl implements EmployeeDAO {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public CommandResult getEmployee(String status) {
		BasicDBObject matchParam = new BasicDBObject("$match", new BasicDBObject("status", status));
		BasicDBObject groupParam = new BasicDBObject("_id", "$cust_id");
		groupParam.append("Total", new BasicDBObject("$sum", "$amount"));
		BasicDBObject object4 = new BasicDBObject();
		object4.append("$group", groupParam);

		BasicDBObject cmdBody = new BasicDBObject("aggregate", "Employee");
		ArrayList<BasicDBObject> pipeline = new ArrayList<BasicDBObject>();
		pipeline.add(matchParam);
		pipeline.add(object4);
		cmdBody.put("pipeline", pipeline);
		System.out.println(pipeline);
		System.out.println();
		System.out.println(cmdBody);
		CommandResult commandResult = mongoTemplate.executeCommand(cmdBody);

		System.out.println(commandResult);

		return commandResult;

	}

}

/*
 * BasicDBObject cmdBody = new BasicDBObject("aggregate", "test");
 * ArrayList<BasicDBObject> pipeline = new ArrayList<BasicDBObject>();
 * pipeline.add(match); pipeline.add(grouping); cmdBody.put("pipeline",
 * pipeline); CommandResult commandResult =
 * mongoTemplate.executeCommand(cmdBody);
 * 
 */

// dboject.append("al", al);
/*
 * Criteria criteria = new Criteria(); criteria.in(al); criteria.is(al);
 * criteria.all(al); criteria.getCriteriaObject(); criteria.gt(al);
 * criteria.all(al); Query query = new Query(criteria);
 * System.out.println(query);
 */
// return mongoTemplate.find(query, Employee.class);
// return (List<Employee>) mongoTemplate.executeCommand("[{$match : { status :
// \"A\"}}, { $group : { _id : \"$cust_id\" , Total : { \"$sum\" :
// \"$amount\"}}}]");
