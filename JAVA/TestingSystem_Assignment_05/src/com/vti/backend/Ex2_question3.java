package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.HinhVuong;

public class Ex2_question3 {
	Scanner sc = new Scanner(System.in);
	HinhVuong hv;
	private float a;

	public void question3() {
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
			System.out.format(leftAlign, "1. Tạo hình vuông");
			System.out.format(leftAlign, "2. Tính chu vi");
			System.out.format(leftAlign, "3. Tính diện tích");
			System.out.format(leftAlign, "4. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập vào cạnh của hình vuông: ");
				a = sc.nextFloat();
				hv = new HinhVuong(a);
				System.out.println("Bạn vừa tạo thành công hình vuông có cạnh " + a);

				break;
			case 2:
//				System.out.println("Chu vi của hình vuông là: " + hv.chuVi());
				System.out.println("Chu vi của hình vuông là: " + a * 4);
				break;
			case 3:
//				System.out.println("Diện tích của hình vuông là: " + hv.dienTich());
				System.out.println("Diện tích của hình vuông là: " + a * a);
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
