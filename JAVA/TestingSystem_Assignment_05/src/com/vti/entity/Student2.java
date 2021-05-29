package com.vti.entity;

import java.util.Scanner;

public class Student2 extends Person {
	private int id;
	private float dtb;
	private String email;
	private static int COUNT = 0;

	@Override
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin sinh vien: (id autocreament)");
//		System.out.println("ID: ");
		COUNT++;
		this.id = COUNT;
		System.out.println("Diem tb: ");
		this.dtb = sc.nextFloat();
		System.out.println("email: ");
		this.email = sc.next();
	}

	@Override
	public String showInfo() {
		return "[ id= " + COUNT + ", Diem tb=" + dtb + ", email=" + email + "]";

	}

	public boolean hocBong() {
		return dtb > 8.0 ? true : false;
	}
}
