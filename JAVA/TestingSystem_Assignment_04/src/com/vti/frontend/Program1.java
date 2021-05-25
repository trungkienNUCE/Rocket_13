package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise1_Constructor;

public class Program1 {

	public static void main(String[] args) {
		Exercise1_Constructor ex01 = new Exercise1_Constructor();
		
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-45s  |%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|		Nhập chức năng			 |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Câu 1");
			System.out.format(leftAlign, "2. Câu 2");
			System.out.format(leftAlign, "3. Câu 3");
			System.out.format(leftAlign, "4. Thoát");
			System.out.format("+------------------------------------------------+%n");

			choose = sc.nextInt();
			switch (choose) {
			case 1:
				ex01.question1();
				break;
			case 2:
				ex01.question2();
				break;
			case 3:
				ex01.question3();
				break;
			case 4:
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1 - để tiếp tục, Nhập bất kỳ để thoát");
				String tt1 = sc.next();
				if (tt1.equals("1")) {
					System.out.println("Nhập lại chức năng");
					break;
				} else {
					System.out.println("Good Bye!");
					return;
				}
			default:
				System.out.println("Nhập lại");
				break;
			}
		}
	}

}
