package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Person;
import com.vti.entity.Student2;

public class Ex2_question2 {
	Scanner sc = new Scanner(System.in);

	public void question2() {
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
			System.out.format(leftAlign, "1. Phan a + b. Demo PerSon");
			System.out.format(leftAlign, "2. Phan c + d. Demo Student");
			System.out.format(leftAlign, "3. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				demoPerson();
				break;

			case 2:
				demoStudent();
				break;
			case 3:
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

	private void demoPerson() {
		Person person = new Person();
		person.inputInfo();
		System.out.println("Thông tin person vừa nhập vào: ");
		System.out.println(person.showInfo());

	}

	private void demoStudent() {
		Student2 st = new Student2();
		st.inputInfo();
		System.out.println("Thông tin Student vừa nhập vào: ");
		System.out.println(st.showInfo());
		if (st.hocBong()) {
			System.out.println("Sinh viên này đạt học bổng");
		} else {
			System.out.println("Sinh viên này không đạt học bổng");
		}
	}

}
