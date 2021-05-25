package com.vti.entity;

public class Department2 {
	private int id;
	public String name;
	
	@Override
	public String toString() {
		return "Department{" + "id=" + getId() + ", name='" + getName() + '\'' + '}';
	}
	
	
	

	public Department2() {
		super();
	}




	public Department2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
