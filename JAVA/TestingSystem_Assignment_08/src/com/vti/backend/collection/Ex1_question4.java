package com.vti.backend.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.vti.entity.Student;
import com.vti.entity.Student2;
import com.vti.ultis.ScannerUltis;

public class Ex1_question4 {
	Set<Student2> studentSet = new HashSet<Student2>();
	List<Student2> stList2 = new ArrayList<>();

	public void question4() {
		System.out.println("Bạn muốn nhập bao nhiêu student: ");
		int sl = ScannerUltis.inputIntPositive();
		
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " là :");
			String name = ScannerUltis.inputString();
			studentSet.add(new Student2(name));
		}
		
//		for (int i = 0; i < sl; i++) {
//			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " là :");
//
//			System.out.println("Nhập vào ID: ");
//			int id = ScannerUltis.inputIntPositive();
//			System.out.println("Nhập vào tên sinh viên");
//			String name = ScannerUltis.inputString();
//			Student2 st2 = new Student2(id, name);
//			studentSet.add(st2);
//			stList2.add(st2);
//		}

		System.out.println("Tổng số sinh viên là: " + studentSet.size());
		System.out.println("Dùng iterator: ");
		Iterator<Student2> iteratorStudent = studentSet.iterator();
		while (iteratorStudent.hasNext()) {
			Student2 st = iteratorStudent.next();
			System.out.println(st);
		}

		System.out.println("Dùng for: ");
		for (Student2 student2 : studentSet) {
			System.out.println(student2.toString());
		}
	}

	public void question5() {
		System.out.println("Question 5");
		System.out.println("Bạn muốn nhập bao nhiêu student: ");
		int sl = ScannerUltis.inputIntPositive();
		
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " là :");
			String name = ScannerUltis.inputString();
			stList2.add(new Student2(name));
		}
		System.out.println("Sắp xếp theo name và in ra set đó");
		Collections.sort(stList2);
		System.out.println(stList2.toString());
//		TreeSet<Student2> ts = new TreeSet<Student2>(); 
//		System.out.println(ts.toString());

	}
}
