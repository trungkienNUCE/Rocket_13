package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Block;
import com.vti.entity.Contestant;
import com.vti.entity.ITuyenSinh;

public class Ex01_Question2 implements ITuyenSinh {
	ArrayList<Contestant> listContestant = new ArrayList<Contestant>();
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
			System.out.format(leftAlign, "1. Thêm thí sinh");
			System.out.format(leftAlign, "2. Hiển thị thông tin thí sinh");
			System.out.format(leftAlign, "3. Tìm kiếm theo số bao danh");
			System.out.format(leftAlign, "4. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				addContestant();
				break;
			case 2:
				showInfor();
				break;
			case 3:
				findByIdNum();
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

	@Override
	public void addContestant() { 
		System.out.println("Thêm mới thí sinh");
		System.out.println("Nhập vào tên: ");
		String name = sc.next();
		System.out.println("Nhập vào địa chỉ: ");
		String address = sc.next();
		System.out.println("Nhập vào mức ưu tiên: ");
		int priority = sc.nextInt();
		System.out.println("Khối thi (A, B, C): ");
		String block = sc.next();

		Contestant contestant = new Contestant(name, address, priority, new Block(block));

		listContestant.add(contestant);

	}

	@Override
	public void showInfor() {
		for (Contestant contestant : listContestant) {
			System.out.println(contestant);
		}

	}

	@Override
	public void findByIdNum() {
		System.out.println("Nhập số báo danh: ");
		int id = sc.nextInt();
		for (Contestant contestant : listContestant) {
			if (contestant.getIdNum() == id) {
				System.out.println(contestant);
			}
		}

	}

}
