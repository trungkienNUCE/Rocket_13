package com.vti.frontend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;

public class Exersice6_Method {

	public static void main(String[] args) {
//		sochansmaller10();
//		infoAccount();
//		soduongsmaller10();
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-45s  |%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|		Nhập chức năng			 |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlign, "1. In ra số chẵn dương nhỏ hơn 10");
			System.out.format(leftAlign, "2. In thông tin các account");
			System.out.format(leftAlign, "3. In ra số nguyên dương nhỏ hơn 10");
			System.out.format(leftAlign, "4. Thoat");
			System.out.format("+------------------------------------------------+%n");

			choose = sc.nextInt();
			switch (choose) {
			case 1:
				sochansmaller10();
				break;
			case 2:
				infoAccount();
				break;
			case 3:
				soduongsmaller10();
				break;
			case 4:
				break;
			}
			System.out.println();
			System.out.println("Bạn có muốn tiếp tục không?");
			System.out.println("Co - để tiếp tục, Nhập bất kỳ để thoát");
			String tt = sc.next();
			if (tt.equals("Co")) {
				System.out.println("Nhap lai");
			} else {
				System.out.println("Good Bye!");
				return;
			}
		}
	}

//		Question 1:
//		Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10

	private static void sochansmaller10() {
		System.out.print("Sô chẵn nguyên dương nhỏ hơn 10 là: ");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.print(+i + " ");
			}
		}
	}

//		Question 2:
//		Tạo method để in thông tin các account
	private static void infoAccount() {
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "trantrungkien@gmail.com";
		acc1.userName = "trungkien";
		acc1.fullName = "Tran Trung Kien";
		acc1.createDate = LocalDate.of(2011, 8, 9);

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "account02@gmail.com";
		acc2.userName = "account02";
		acc2.fullName = "Full Name 02";
		acc2.createDate = LocalDate.of(2020, 12, 20);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "account03@gmail.com";
		acc3.userName = "account03";
		acc3.fullName = "Full Name 03";
		acc3.createDate = LocalDate.now();

		System.out.println("Thông tin các Account trên hệ thống");
		Account[] accArr = { acc1, acc2, acc3 };
		for (int i = 0; i < accArr.length; i++) {
			System.out.println("Id: " + accArr[i].id);
			System.out.println("fullName: " + accArr[i].fullName);
			System.out.println("userName: " + accArr[i].userName);
			System.out.println("email: " + accArr[i].email);
			System.out.println("createDate: " + accArr[i].createDate);
			System.out.println("--------------------");
		}
	}

//		Question 3:
//		Tạo method để in ra các số nguyên dương nhỏ hơn 10
	private static void soduongsmaller10() {
		System.out.println("");
		System.out.print("Các số nguyên dương nhỏ hơn 10 là: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(+i + " ");
		}
	}
}
