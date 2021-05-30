package com.vti.backend;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

public class Ex2_Exception_Ques9 {

	public void question9_Position() {
		System.out.println("Tạo Position");

		Position pos1 = new Position();
		System.out.println("Thông tin Position vừa nhập: ");
		System.out.println(pos1);
	}

	public void question9_Department() {
		System.out.println("Tao 3 department");
		Department dep1 = new Department();
		Department dep2 = new Department();
		Department dep3 = new Department();
		ArrayList<Department> listDep = new ArrayList<Department>();
		listDep.add(dep1);
		listDep.add(dep2);
		listDep.add(dep3);
		System.out.println("Thông tin phòng vừa nhập: ");
		for (Department department : listDep) {
			System.out.println(department);
		}

	}
}
