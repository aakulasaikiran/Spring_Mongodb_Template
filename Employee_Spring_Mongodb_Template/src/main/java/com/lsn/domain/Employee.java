package com.lsn.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	private String cust_id;
	private int amount;
	private String status;

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee(String cust_id, int amount, String status) {
		super();
		this.cust_id = cust_id;
		this.amount = amount;
		this.status = status;
	}

}
