package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Account {
	public static int COUNT = 0;
	private int id;
	private String email;
	private String userName;
	private String fullName;

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" +

				userName + ", fullName=" + fullName + "]";
	}

	public Account() {
		super();
		System.out.println("Nhập thông tin Account: ");
		COUNT++;
		this.id = COUNT;
		System.out.println("Nhập tên Email: ");
		this.email = ScannerUltis.inputString();
		System.out.println("Nhập tên userName: ");

		this.userName = ScannerUltis.inputString();
		System.out.println("Nhập tên fullName: ");
		this.fullName = ScannerUltis.inputString();
	}

}
