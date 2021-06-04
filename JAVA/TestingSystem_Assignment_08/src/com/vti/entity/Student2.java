package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Student2 implements Comparable<Student2> {
	private static int COUNT = 0;
	private int id;
	private String name;

	public Student2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student2( String name) {
		this.id = ++COUNT;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student2 o) {
		return this.name.compareTo(o.getName());
	}

}
