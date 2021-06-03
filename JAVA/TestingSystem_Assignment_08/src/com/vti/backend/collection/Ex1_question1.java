package com.vti.backend.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Ex1_question1 {
	ArrayList<Student> stList = new ArrayList<Student>();

	public void question1() {
		System.out.println("Bạn muốn nhập bao nhiêu student: ");
		int sl = ScannerUltis.inputIntPositive();
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " là :");
			String name = ScannerUltis.inputString();
			stList.add(new Student(name));
		}

//		Student st1 = new Student("kien");
//		Student st2 = new Student("kien");
//		Student st3 = new Student("kien");
//		Student st4 = new Student("viet");
//		stList.add(st1);
//		stList.add(st2);
//		stList.add(st3);
//		stList.add(st4);

		menu();

	}

	public void menu() {
		while (true) {
			String leftAlign = "| %-50s  |%n";
			System.out.format("%n+=====================================================+%n");
			System.out.format(leftAlign, "========= Lựa chọn chức năng muốn sử dụng ========");
			System.out.format("+=====================================================+%n");
			System.out.format(leftAlign, "1. In ra tổng các phần tử");
			System.out.format(leftAlign, "2. Lấy phần tử thứ 4 của students");
			System.out.format(leftAlign, "3. In ra phần tử đầu và phần tử cuối của students");
			System.out.format(leftAlign, "4. Thêm 1 phần tử vào vị trí đầu của students");
			System.out.format(leftAlign, "5. Thêm 1 phần tử vào vị trí cuối của students");
			System.out.format(leftAlign, "6. Đảo ngược vị trí của students");
			System.out.format(leftAlign, "7. Tạo 1 method tìm kiếm student theo id");
			System.out.format(leftAlign, "8. Tạo 1 method tìm kiếm student theo name");
			System.out.format(leftAlign, "9. Tạo 1 method để in ra các student có trùng tên");
			System.out.format(leftAlign, "10. Xoá name của sv có id nhập vào ");
			System.out.format(leftAlign, "11. Xoá student có tên nhập vào");
			System.out.format(leftAlign, "12. Tạo 1 ArrayList tên là studentCopies");
			System.out.format(leftAlign, "13. Thoát");
			System.out.format("+=====================================================+%n");
			System.out.print("Nhập chức năng: ");
			int menuChoose = ScannerUltis.inputFunction(1, 13, "Chọn lại!");
			switch (menuChoose) {
			case 1:
				part_1();
				break;
			case 2:
				part_2();
				break;
			case 3:
				part_3();
				break;
			case 4:
				part_4();
				break;
			case 5:
				part_5();
				break;
			case 6:
				part_6();
				break;
			case 7:
				part_7();
				break;
			case 8:
				part_8();
				break;
			case 9:
				part_9();
				break;
			case 10:
				part_10();
				break;
			case 11:
				part_11();
				break;
			case 12:
				part_12();
				break;
			case 13:
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1 - để tiếp tục, 0 - để thoát");
				int a = ScannerUltis.inputFunction(0, 1, "Chọn lại");
				if (a == 1) {
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

	public void part_1() {
		System.out.println("Số lượng student là: " + stList.size());
		printStudent();
	}

	public void printStudent() {
		System.out.println("Danh sách sinh viên là: ");
		for (Student student : stList) {
			System.out.println(student);
		}
	}

	public void part_2() {
		System.out.println("Phần tử thứ 4 là: ");
		System.out.println(stList.get(3));
	}

	public void part_3() {
		System.out.println("Phần tử đầu tiên là: ");
		System.out.println(stList.get(0));
		System.out.println("Phần tử cuối cùng là: ");
		System.out.println(stList.get(stList.size() - 1));

	}

	public void part_4() {
		System.out.println("Thêm 1 student vào vị trí đầu tiên: ");
		System.out.println("Nhập tên student: ");
		stList.add(0, new Student(ScannerUltis.inputString()));
		printStudent();

	}

	public void part_5() {
		System.out.println("Thêm 1 student vào vị trí cuối cùng: ");
		System.out.println("Nhập tên student: ");
		stList.add(stList.size(), new Student(ScannerUltis.inputString()));

		printStudent();
	}

	public void part_6() {
		System.out.println("Đảo ngược vị trí trong danh sách: ");
		Collections.reverse(stList);
		printStudent();
	}

	public void part_7() {
		System.out.println("Tìm kiếm theo ID. Nhập ID: ");
		int id = ScannerUltis.inputIntPositive();
		for (Student student : stList) {
			if (student.getId() == id) {
				System.out.println("Sinh viên cần tìm là: " + student);
			}
		}
	}

	public void part_8() {
		System.out.println("Tìm kiếm theo tên. Nhập tên: ");
		String name = ScannerUltis.inputString();
		for (Student student : stList) {
			if (student.getName().equals(name)) {
				System.out.println("Sinh viên cần tìm là: " + student);
			}
		}

	}

	public void part_9() {
		System.out.println("Các sinh viên có trùng tên là: ");
		for (int i = 0; i < stList.size(); i++) {
			for (int j = i + 1; j < stList.size(); j++) {
				if (stList.get(i).getName().equals(stList.get(j).getName())) {
//					System.out.println(stList.get(i).getId());
//					System.out.println(stList.get(i).getName());
					System.out.println(stList.get(i).toString());

				}
			}
		}
	}

	public void part_10() {
		System.out.println("Nhập ID của sinh viên cần xoá tên: ");
		int id = ScannerUltis.inputIntPositive();
		for (Student student : stList) {
			if (student.getId() == id) {
				student.setName(null);
			}
		}
		printStudent();
	}

	public void part_11() {
		System.out.println("Nhập vào tên sinh viên cần xoá: ");
		String delName = ScannerUltis.inputString();

//		cach1
//		Iterator<Student> iterator = stList.iterator();
//		while (iterator.hasNext()) {
//			Student student = (Student) iterator.next();
//			if (student.getName().equals(delName)) {
//				iterator.remove();
//			}
//		}
//		printStudent();

//		cach2
		stList.removeIf(student -> student.getName().equals(delName));
		printStudent();

	}

	public void part_12() {
		ArrayList<Student> stListCopies = new ArrayList<Student>();
		stListCopies.addAll(stList);
		System.out.println("Danh sách sinh viên copy là:");
		for (Student student : stListCopies) {
			System.out.println(student);
		}

	}

}
