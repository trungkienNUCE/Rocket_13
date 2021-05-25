package com.vti.entity;

public class DepartmentCons {
	public int id = 0;
	public String name;
	
	public DepartmentCons(int id, String name) {
		super();
		this.id = 0;
		this.name = name;
	}
	
	public DepartmentCons() {
		super();
	}

	@Override
	public String toString() {
		return "DepartmentCons [id=" + id + ", name=" + name + "]";
	}
	
	
}
