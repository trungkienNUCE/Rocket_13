package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

import com.vti.ultis.ScannerUltis;

public class Group {
	public static int COUNT = 0;
	private int id;
	private String name;
	private Account creator;
	private LocalDate createDate;
	private Account[] accounts;

	public void printInforGroup() {
		System.out.println("Thông tin Group:");
		System.out.println("Group [id=" + id + ", name=" + name + ", createDate=" + createDate + "]");
		if (accounts != null) {
			System.out.println("Số lượng Account trong Group này là: " +

					accounts.length);

			for (Account account : accounts) {
				System.out.println(account.toString());
			}
		}
	}

	public Group() {
		super();
		System.out.println("Nhập thông tin tạo Group: ");
		COUNT++;
		this.id = COUNT;
		System.out.println("Nhập tên Group: ");
		this.name = ScannerUltis.inputString();
		System.out.println("Nhập ngày tạo Group: ");
		this.createDate = ScannerUltis.inputLocalDate();
		System.out.println("Bạn có muốn thêm Account vào Group hay không? 1.Có, 2.Không");

		while (true) {
			int chooseAddAcc = ScannerUltis.inputIntPositive();
			switch (chooseAddAcc) {
			case 1:
				System.out.println("Nhập số lượng account muốn thêm vào Group này: ");

				int countAcc = ScannerUltis.inputIntPositive();
				Account[] accs = new Account[countAcc];
				for (int i = 0; i < countAcc; i++) {
					System.out.println("Nhập vào Account thứ " + (i + 1) + ": ");

					Account acc = new Account();
					accs[i] = acc;
				}
				this.accounts = accs;
				return;
			case 2:
				return;
			default:
				System.out.println("Nhập lại: ");
				break;
			}
		}
	}
}
