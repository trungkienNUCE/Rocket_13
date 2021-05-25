package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Exercise1_Constructor {

	public void question1() {
//		a
//		Department dep1 = new Department();
//		dep1.id = 1;
//		dep1.name = "Phong Hop";
//		
//		Department dep2 = new Department();
//		dep2.id = 2;
//		dep2.name = "Phong Hop";
//		
//		Department dep3 = new Department();
//		dep3.id = 3;
//		dep3.name = "Phong Hop";
//		
//		Department dep4 = new Department();
//		dep4.id = 4;
//		dep4.name = "Phong Hop";
//		
//		Department[] depArr = new Department[4];
//		depArr[0] = dep1;
//		depArr[1] = dep2;
//		depArr[2] = dep3;
//		depArr[3] = dep4;
//		
//		for (Department department : depArr) {
//		System.out.println(department.toString());	
//		}

//		b
		Department dep1 = new Department(1, "Phòng Họp");
		Department dep2 = new Department(2, "Phòng Chờ");
		Department dep3 = new Department(3, "Phòng Sale");
		Department dep4 = new Department(4, "Phòng MKT");

//		khai bao kieu mang
//		Department[] depArr = new Department[4];
//		depArr[0] = dep1;
//		depArr[1] = dep2;
//		depArr[2] = dep3;
//		depArr[3] = dep4;
//		
//		for (Department department : depArr) {
//		System.out.println(department.toString());	
//		}

//		khai bao kieu arraylist
		ArrayList<Department> depArrList = new ArrayList<Department>();
		depArrList.add(dep1);
		depArrList.add(dep2);
		depArrList.add(dep3);
		depArrList.add(dep4);

		for (Department department : depArrList) {
			System.out.println(department.toString());
		}
	}

	public void question2() {

		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";

		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

//		a
//		Account acc1 = new Account();
//		acc1.id = 1;
//		acc1.email = "trantrungkien@gmail.com";
//		acc1.userName = "trungkien";
//		acc1.firstName = "Kien";
//		acc1.lastName = "Tran Trung";
//		acc1.fullName = "Tran Trung Kien";
//		acc1.position = pos1;
//		acc1.department = dep1;
//		acc1.createDate = LocalDate.now();
//		
//		System.out.println("Thong tin ACCOUNT 01");
//		System.out.println("ID: " + acc1.id);
//		System.out.println("Email: " + acc1.email);
//		System.out.println("Username: " + acc1.userName);
//		System.out.println("Fullname: " + acc1.fullName);
//		System.out.println("Department: " + acc1.department.name);
//		System.out.println("Position: "  + acc1.position.name);
//		System.out.println("CreateDate: " + acc1.createDate);

//		phần b,c là d tách nhỏ

//		d: chưa in được ra tên postion
		Account acc1 = new Account(1, "trantrungkien@gmail.com", "trungkien", "Kien", "Tran Trung", pos1);
		System.out.println(acc1.toString());

	}

	public void question3() {
//		a
//		Group group1 = new Group();
//		group1.id = 1;
//		group1.name = "Java Fresher";
//		group1.createDate = LocalDate.of(2020, 8, 1);
//
//		Group group2 = new Group();
//		group2.id = 2;
//		group2.name = "Development";
//		group2.createDate = LocalDate.of(2020, 3, 1);
//
//		Group group3 = new Group();
//		group3.id = 3;
//		group3.name = "Testing System";
//		group3.createDate = LocalDate.of(2020, 1, 1);
//		
//		ArrayList<Group> groupArrList = new ArrayList<Group>();
//		groupArrList.add(group1);
//		groupArrList.add(group2);
//		groupArrList.add(group3);
//		
//		for (Group group : groupArrList) {
//			System.out.println(group.toString());
//		}

//		b,c

		Account acc1 = new Account();
		acc1.id = 1;
		acc1.userName = "trungkien";
		acc1.fullName = "Tran Trung Kien";

		Account acc2 = new Account();
		acc2.id = 1;
		acc2.userName = "trungkien";
		acc2.fullName = "Tran Trung Kien";

		Account[] accGroup1 = { acc1, acc2 };

		Group group1 = new Group(1, "Dev", acc1, LocalDate.of(2020, 2, 1), accGroup1);
		System.out.println("Id: " + group1.id + " Ten nhom: " + group1.name + " Nguoi tao: " + group1.creatorId.id
				+ " Ngay tao: " + group1.createDate + Arrays.toString(accGroup1));

	}

}
