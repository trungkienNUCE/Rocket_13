package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.Student;

public class Exercise2_Polymorphism {
//	Student[] students = new Student[10];
	ArrayList<Student> students = new ArrayList<Student>();

	public void question1a() {
		students.add(new Student(1, "Trần Trung Kiên", 3));
		students.add(new Student(2, "Nguyễn Văn Hiếu", 1));
		students.add(new Student(3, "Nguyễn Văn Tùng", 1));
		students.add(new Student(4, "Nguyễn Hữu Hùng", 1));
		students.add(new Student(5, "Trần Văn Tiến", 2));
		students.add(new Student(6, "Trần Văn Quân", 3));
		students.add(new Student(7, "Trần Văn Duy", 2));
		students.add(new Student(8, "Trần Thị Chi", 3));
		students.add(new Student(9, "Trần Thị Linh", 2));
		students.add(new Student(10, "Trần Anh Tuấn", 1));

	}

	public void question1b() {
		System.out.println("CẢ LỚP ĐIỂM DANH");
		for (Student student : students) {
			student.diemDanh();
		}
		System.out.println("----------------");
	}

	public void question1c() {
		System.out.println("NHÓM 1 ĐI HỌC BÀI");
		for (Student student : students) {
			if (student.getGroup() == 1) {
				student.hocBai();
			}
		}
		System.out.println("----------------");
	}

	public void question1d() {
		System.out.println("NHÓM 2 ĐI DỌN VỆ SINH");
		for (Student student : students) {
			if (student.getGroup() == 2) {
				student.donVeSinh();
			}

		}
		System.out.println("----------------");
	}

}
