package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Staff;
import com.vti.entity.Student;
import com.vti.entity.Worker;

public class Exercise4_Encapsulation {
	ArrayList<Student> studentList = new ArrayList<Student>();
	Scanner sc = new Scanner(System.in);

	public void question1() {
		ArrayList<Student> studentList = new ArrayList<Student>();

		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Thêm thông tin sinh viên");
			System.out.format(leftAlign, "2. Sửa điểm cho sinh viên");
			System.out.format(leftAlign, "3. Danh sách xếp loại sinh viên");
			System.out.format(leftAlign, "4. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				setPoint();
				break;
			case 2:
				editPoint();
				break;
			case 3:
				print();
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

	private void print() {
		System.out.println("----Danh sách xếp loại sinh viên----");
		for (Student student : studentList) {
			System.out.println(student.toString());
		}
	}

	private void editPoint() {
		System.out.print("Nhập ID sinh viên cần sửa điểm: ");
		int id = sc.nextInt();
		for (Student student : studentList) {
			if (student.getId() == id) {
				System.out.print("Cộng điểm cho sinh viên " + student.getName().toUpperCase() + "  Số điểm cộng thêm:");
				float addPoint = sc.nextFloat();
				float newPoint = student.getPoint() + addPoint;
				student.setPoint(newPoint);
				System.out.println("Thông tin sinh viên vừa sửa điểm: ");
				System.out.println("ID: " + student.getId() + " , Tên: " + student.getName() + " , Hometown: "
						+ student.getHometown() + " , Điểm: " + student.getPoint());
			}
		}
	}

	private void setPoint() {
		System.out.println("----Thêm thông tin sinh viên----");

		System.out.println("ID: ");
		int id = sc.nextInt();

		System.out.println("Tên: ");
		String name = sc.next();

		System.out.println("Hometown: ");
		String hometown = sc.next();

		System.out.println("Nhập điểm");
		float point = sc.nextFloat();

		Student student = new Student(id, name, hometown, point);
		studentList.add(student);

		System.out.println("Thông tin sinh viên vừa thêm là: ");
		System.out.println("ID: " + student.getId() + " , Tên: " + student.getName() + " , Hometown: " + student.getHometown()
				+ " , Điểm: " + student.getPoint());
	}

}
