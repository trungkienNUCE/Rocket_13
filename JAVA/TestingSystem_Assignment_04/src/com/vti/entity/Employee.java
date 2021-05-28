package com.vti.entity;

import com.vti.backend.Gender;

public class Employee extends Staff {
	private String task;

	@Override
	public String toString() {
		return super.toString() + " Công việc: " + task + "]";
	}

	public Employee(String name, int age, Gender gender, String address, String task) {
		super(name, age, gender, address);
		this.task = task;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
