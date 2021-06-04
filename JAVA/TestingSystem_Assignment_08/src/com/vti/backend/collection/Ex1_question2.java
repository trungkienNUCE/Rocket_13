package com.vti.backend.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Ex1_question2 {
	Stack<Student> stackStudent = new Stack<>();

	public void question2() {
		menu2();
	}

	private void menu2() {
		while (true) {
			String leftAlign = "| %-50s  |%n";
			System.out.format("%n+=====================================================+%n");
			System.out.format(leftAlign, "========= Lựa chọn chức năng muốn sử dụng ========");
			System.out.format("+=====================================================+%n");
			System.out.format(leftAlign, "1. Thêm sinh viên dùng Stack");
			System.out.format(leftAlign, "2. Lấy ra sinh viên đến muộn nhất");
			System.out.format(leftAlign, "3. Dùng Stack sắp xếp thứ tự");
			System.out.format(leftAlign, "4. Thêm sinh viên dùng Queue và sắp xếp");
			System.out.format(leftAlign, "5. Thoát");
			System.out.format("+=====================================================+%n");
			System.out.print("Nhập chức năng: ");
			int menuChoose = ScannerUltis.inputFunction(1, 5, "Chọn lại!");
			switch (menuChoose) {
			case 1:
				System.out.println("Bạn muốn nhập bao nhiêu student: ");
				int sl = ScannerUltis.inputIntPositive();
				for (int i = 0; i < sl; i++) {
					Student st = new Student("Student " + (i + 1));
					stackStudent.push(st);
				}
				System.out.println("Đã tạo thành công " + sl + " sinh viên vào Stack");
				break;
			case 2:
				System.out.println("Sinh viên đến muộn nhất là: ");
				System.out.println(stackStudent.peek());

				break;
			case 3:
				System.out.println("Thứ tự sinh viên theo thứ tự từ sớm nhất đến muộn nhất: ");
				Iterator<Student> iteratorStudent = stackStudent.iterator();
				while (iteratorStudent.hasNext()) {
					Student st = iteratorStudent.next();
					System.out.println(st);
				}
				System.out.println("------------------------");
				System.out.println("Thứ tự sinh viên theo thứ tự từ muộn nhất đến sớm nhất: ");
				Iterator<Student> iteratorStudent2 = stackStudent.iterator();
				for (int i = 0; i < stackStudent.size(); i++) {
					System.out.println(stackStudent.pop());
				}
				System.out.println("Số sinh viên còn lại trong Stack: " + stackStudent.size());

				break;
			case 4:
				Queue<Student> queueStudent = new LinkedList<>();
				System.out.println("Dùng Queue");
				System.out.println("Bạn muốn nhập bao nhiêu sinh viên: ");
				int sl2 = ScannerUltis.inputIntPositive();
				for (int i = 0; i < sl2; i++) {
					Student st2 = new Student("Student " + (i + 1));
					queueStudent.add(st2);
				}
				System.out.println("Thứ tự sinh viên theo thứ tự từ sớm nhất đến muộn nhất dùng Queue: ");
				for (int i = 0; i < sl2; i++) {
					System.out.println(queueStudent.poll());
				}

				break;

			case 5:
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
}
