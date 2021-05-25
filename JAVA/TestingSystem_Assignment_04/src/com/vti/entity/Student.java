package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float point;

	public Student(int id, String name, String hometown) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.point = point;
	}

	public Student(int id, String name, String hometown, float point) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.point = point;
	}

	@Override
	public String toString() {
		String grade;
		if (point < 4.0) {
			grade = "Yếu";
		} else if (point < 6) {
			grade = "Trung bình";
		} else if (point < 8) {
			grade = "Khá";
		} else {
			grade = "Giỏi";
		}
//		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", hometown='" + hometown + '\'' + ", score="
//				+ point + ", xepLoai='" + grade + '\'' + '}';

		return "Student{" + "Tên: '" + name + '\'' +  ", Xếp loại: '" + grade + '\'' + '}';
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public void setPlusPoint(float newPoint) {
		this.point = newPoint;
	}
}
