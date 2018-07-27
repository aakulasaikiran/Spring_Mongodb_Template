package com.lsn.repository;

import java.util.ArrayList;
import java.util.List;

import com.lsn.domain.Employee;
import com.mongodb.CommandResult;

public interface EmployeeDAO {

	public  CommandResult getEmployee(String status);
	
	
	
}
