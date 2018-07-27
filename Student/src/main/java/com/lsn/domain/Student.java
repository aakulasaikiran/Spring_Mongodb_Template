package com.lsn.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	@Id
	private int stid;
	private String stname;
	private String gender;
	private int age;

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(int stid, String stname, String gender, int age) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [sid=" + stid + ", name=" + stname + ", age=" + age
				+ ", Gnder=" + gender + "]";
	}
}
