package com.vti.entity;

public class Student {
	private static int COUNT;
	private int id;
	private String name;

	/**
	 * 
	 * @deprecated replace by {@link #getIdWithMSV()}
	 */
	@Deprecated
	public int getId() {
		return id;
	}

	public String getIdWithMSV() {
		return "MSV: " + id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Student(String name) {
		super();
		this.id = ++COUNT;
		this.name = name;
	}

}
