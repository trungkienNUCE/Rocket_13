package com.vti.entity;

public class Student2 {

	private final int id;
	private String name;

	public Student2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + getId() + '\'' + "name='" + name + '\'' + '}';
	}

	public final static void study() {
		System.out.println("Đang học bài…");
	}
}
