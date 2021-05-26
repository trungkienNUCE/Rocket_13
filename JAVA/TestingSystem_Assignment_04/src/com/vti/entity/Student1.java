package com.vti.entity;

public abstract class Student1 extends Person implements IFamily, IRelax, IStudy{
	private int id;

	public Student1(int id, String name) {
		super(name);
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student1 [id=" + id + "]" + super.toString();
	}

	

	
}
