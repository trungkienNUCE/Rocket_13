package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2 {

	public void question1() {
		@SuppressWarnings("deprecation")
		Date date = new Date("18/05/2020");
	}

	@SuppressWarnings("deprecation")
	public void question2() {
		Student st1 = new Student("Nguyen Van A");
		System.out.println(st1.getId() + "-" + st1.getName());
		System.out.println(st1.getIdWithMSV() + "-" +  st1.getName());
	}
	
}
