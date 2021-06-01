package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.MyMath2;
import com.vti.entity.PrimaryStudent2;
import com.vti.entity.SecondaryStudent2;
import com.vti.entity.Student2;

public class Final {

	public void question1() {
		System.out.println("Question 1");
		System.out.println("Tong so a voi PI: " + MyMath2.sum(7));
	}

	public void question2() throws Exception {
		System.out.println("Question 2");
		ArrayList<Student2> arrSt = new ArrayList<Student2>();
		arrSt.add(new Student2(1, "Nguyen Van A"));
		arrSt.add(new Student2(2, "Nguyen Van B"));
		arrSt.add(new Student2(3, "Nguyen Van C"));

		for (Student2 student2 : arrSt) {
			System.out.println(student2);
		}

	}

	public void question3() {
		System.out.println("Question 3");
		PrimaryStudent2.study();
		SecondaryStudent2.study();
	}
}
