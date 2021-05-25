package com.vti.entity;

import java.util.Arrays;

public class Department {
	public int id = 0;
	public String name;
	public Account[] accounts;
//a	
	public Department() {
		super();
	}
//b
	public Department(int id, String name) {
		super();
		this.id = 0;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", accounts=" + Arrays.toString(accounts) + "]";
	}
	
	
	
}
