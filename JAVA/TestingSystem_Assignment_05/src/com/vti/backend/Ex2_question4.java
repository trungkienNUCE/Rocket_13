package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.MyMath;

public class Ex2_question4 {
	Scanner sc = new Scanner(System.in);
	MyMath myMath = new MyMath();

	public void tinhTong() {
		menu();

	}

	private void menu() {
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Tính tổng 2 số nguyên int");
			System.out.format(leftAlign, "2. Tính tổng 2 số kiểu byte");
			System.out.format(leftAlign, "3. Tính tổng 2 số kiểu float");
			System.out.format(leftAlign, "4. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập vào số int 1: ");
				int int1 = sc.nextInt();
				System.out.println("Nhập vào số int 2: ");
				int int2 = sc.nextInt();
				System.out.println("Tổng 2 số là: " +

						myMath.getSum(int1, int2));
				break;

			case 2:
				System.out.println("Nhập vào số byte 1: ");
				byte byte1 = sc.nextByte();
				System.out.println("Nhập vào số byte 2: ");
				byte byte2 = sc.nextByte();
				System.out.println("Tổng 2 số là: " +

						myMath.getSum(byte1, byte2));
				break;
			case 3:
				System.out.println("Nhập vào số float 1: ");
				Float float1 = sc.nextFloat();
				System.out.println("Nhập vào số float 2: ");
				Float float2 = sc.nextFloat();
				System.out.println("Tổng 2 số là: " +

						myMath.getSum(float1, float2));
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
