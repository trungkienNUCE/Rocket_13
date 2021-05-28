package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Contact;
import com.vti.entity.Employee2;
import com.vti.entity.Manager;
import com.vti.entity.VietnamesePhone;
import com.vti.entity.Waiter;

public class Exercise6_Abstraction {
	Scanner sc = new Scanner(System.in);
	public ArrayList<Contact> contacts;

	public void VietnamesePhone() {
		contacts = new ArrayList<Contact>();
	}

//	public void Exercise6() {
//	}

	public void question1() {
		loadmenuAbstract();
	}

	public void insertContact(String name, String phone) {
		Contact contact = new Contact(name, phone);
		contacts.add(contact);
	}

	public void removeContact(String name) {
		contacts.removeIf(contact -> contact.getName().equals(name));
	}

	public void updateContact(String name, String newPhone) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				contact.setPhone(newPhone);
			}
		}
	}

	public void searchContact(String name) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				System.out.println(contact);
			}
		}
	}

	private void loadmenuAbstract() {
		VietnamesePhone vnPhone = new VietnamesePhone();
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. InsertContact");
			System.out.format(leftAlign, "2. RemoveContact");
			System.out.format(leftAlign, "3. UpdateContact");
			System.out.format(leftAlign, "4. SearchContact");
			System.out.format(leftAlign, "5. ShowContact");
			System.out.format(leftAlign, "5. Exit");
			System.out.format("+-------------------------------------------------+%n");

			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào tên Contact: ");
				String name = sc.next();
				System.out.println("Nhập vào tên số Phone: ");
				String phone = sc.next();
				vnPhone.insertContact(name, phone);
				break;
			case 2:
				System.out.println("Nhập vào tên Contact cần remove: ");

				String removeName = sc.next();
				vnPhone.removeContact(removeName);
				break;
			case 3:
				System.out.println("Nhập tên cần Update: ");
				String name1 = sc.next();
				System.out.println("Nhập số Phone mới: ");
				String newPhone = sc.next();
				vnPhone.updateContact(name1, newPhone);
				System.out.println("Kết quả: ");
				vnPhone.searchContact(name1);
				break;
			case 4:
				System.out.println("Nhập vào tên Contact cần tìm kiếm: ");

				String searchName = sc.next();
				vnPhone.searchContact(searchName);
				break;
			case 5:
				vnPhone.printContact();
				break;
			case 6:
				return;
			default:
				System.out.println("Alarm: Lựa chọn đúng số trên menu");

				break;
			}
		}

	}

	public void question23() {
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Thêm Employee");
			System.out.format(leftAlign, "2. Thêm Manager");
			System.out.format(leftAlign, "3. Thêm Waiter");
			System.out.format(leftAlign, "5. Thoát");
			System.out.format("+-------------------------------------------------+%n");

			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào tên Employee: ");
				String emName = sc.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double emSalaryRatio = sc.nextDouble();
				Employee2 em = new Employee2(emName, emSalaryRatio);

				em.displayInfor();
				break;
			case 2:
				System.out.println("Nhập vào tên Manager: ");
				String managerName = sc.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double managerSalaryRatio = sc.nextDouble();
				Manager manager = new Manager(managerName, managerSalaryRatio);

				manager.displayInfor();
				break;
			case 3:
				System.out.println("Nhập vào tên Waiter: ");
				String waiterName = sc.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double waiterSalaryRatio = sc.nextDouble();
				Waiter waiter = new Waiter(waiterName, waiterSalaryRatio);

				waiter.displayInfor();
				break;
			case 4:
				return;

			default:
				System.out.println("Alarm: Lựa chọn đúng số!");

				break;

			}
		}
	}
}
