package com.vti.frontend;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Exercise1_DatatypeCasting {

	public static void main(String[] args) {
//		question01();
//		question02();
//		question03();
//		question04();
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
			System.out.format(leftAlign, "4. Câu 4");
			System.out.format(leftAlign, "5. Thoát");
			System.out.format("+------------------------------------------------+%n");

			choose = sc.nextInt();
			switch (choose) {
			case 1:
				question01();
				break;
			case 2:
				question02();
				break;
			case 3:
				question03();
				break;
			case 4:
				question04();
				break;
			case 5:
				break;
			}
			System.out.println();
			System.out.println("Bạn có muốn tiếp tục không?");
			System.out.println("1 - để tiếp tục, Nhập bất kỳ để thoát");
			String tt = sc.next();
			if (tt.equals("1")) {
				System.out.println("Nhap lai");
			} else {
				System.out.println("Good Bye!");
				return;
			}
		}
	}
	
	private static void question01() {
		float s1 = 5240.5f;
		float s2 = 10970.055f;

		int i1 = (int) s1;
		System.out.println("Lương làm tròn ACC1: " + i1);

		int i2 = (int) s2;
		System.out.println("Lương làm tròn ACC2: " + i2);
	}

	private static void question02() {
		Random random = new Random();
		int a = random.nextInt(100000);
		while (a < 10000) {
			a = a * 10;
		}
		System.out.printf(Locale.US, "Số ngẫu nhiên có 5 chữ số: %,d  %n", +a);
	}

	private static void question03() {
		Random random = new Random();
		int a = random.nextInt(100000);
		while (a < 10000) {
			a = a * 10;
		}

		System.out.printf(Locale.US, "Số ngẫu nhiên có 5 chữ số: %,d  %n", +a);
//		cach 1
		int b = (int) (a % 100);
		System.out.println("Cách 1: 2 chữ số cuối phần 2 là: " + b);
		
//		cach 2
		String c = String.valueOf(a);
		System.out.println("Cách 2: 2 chữ số cuối phần 2 là: " + c.substring(3));
		
	}

	private static void question04() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap a = ");
		int a = sc.nextInt();
		System.out.print("Nhap b = ");
		int b = sc.nextInt();

		float c = (float) a / b;
		System.out.println("a/b = " + c);
	}

}
