package com.vti.entity;

public class Student7 implements Comparable<Student7> {
	private static int COUNT = 0;
	private int id;
    private String name;


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

	public Student7(String name) {
		super();
		this.id = ++COUNT;
		this.name = name;
	}

	// override equals and hashCode
    @Override
    public int compareTo(Student7 student) {
    	return this.name.compareTo(student.getName());
    }

	@Override
	public String toString() {
		return "Thông tin [id=" + id + ", Tên=" + name + "]";
	}
    
}
