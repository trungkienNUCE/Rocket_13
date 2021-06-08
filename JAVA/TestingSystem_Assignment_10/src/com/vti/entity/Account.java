package com.vti.entity;

import java.time.LocalDate;
import java.util.Date;

public class Account {
	private int accountId;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	public String getEmail() {
		return email;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDep() {
		return department;
	}

	public void setDep(Department dep) {
		this.department = dep;
	}

	public Position getPos() {
		return position;
	}

	public void setPos(Position pos) {
		this.position = pos;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account(String email, String userName, String fullName, Department dep, Position pos,
			Date createDate) {
		super();
//		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = dep;
		this.position = pos;
		this.createDate = createDate;
	}
	public Account() {
		super();
	} 
	
}
