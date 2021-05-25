package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String firstName;
	public String lastName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;
	public Group[] groups;
	
//	constructor khong parameters
	public Account() {
		super();
	}

//	b
public Account(int id, String email, String userName, String firstName, String lastName, 
		Position position) {
	super();
	this.id = id;
	this.email = email;
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.fullName = firstName + lastName;
	this.position = position; 
	this.createDate = LocalDate.now();
}

@Override
public String toString() {
	return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", fullName=" + fullName + ", department=" + department + ", position="
			+ position + ", createDate=" + createDate + ", groups=" + Arrays.toString(groups) + "]";
}


	

	
	
}
