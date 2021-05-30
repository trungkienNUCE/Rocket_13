package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Department {
	public static int COUNT = 0;
	private int id;
	private String depName;
	public Department(String depName) {
		super();
		COUNT++;
		this.id = COUNT;
		this.depName = depName;
	}
	public Department() {
		super();
		COUNT++;
		this.id = COUNT;
		System.out.println("Nhap ten phong: ");
		this.depName = ScannerUltis.inputString();
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + "]";
	}
	
}
