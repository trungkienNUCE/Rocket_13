//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presertationlayer.UserController;
import com.vti.entity.User;
import com.vti.ultis.ScannerUltis;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 14, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 14, 2021
 */
public class Function {
	private UserController userControler;

	public Function() throws FileNotFoundException, IOException {
		userControler = new UserController();
	}

	public boolean islogin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào Password: ");
		String pass = ScannerUltis.inputPassword();
		return userControler.isLogin(email, pass);
	}

	public void showMenuMain() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tìm thành viên của Project theo ID");
			System.out.format(leftAlignFormat, "2. Lấy ra danh sách Manager của các project");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				getMenberByProjectID();
				break;
			case 2:
				getManagerInProjects();

				break;
			case 3:

				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}

	private void getManagerInProjects() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<User>();
		list = userControler.getManagerInProjects();
		System.out.println("Danh sách Manager của các project: ");
		String leftAlignFormat = "| %-2d | %-25s | %-21s |%n";
		System.out.format("+----+---------------------------+-----------------------+%n");
		System.out.format("|ID  | Email                     |   FullName            |%n");
		System.out.format("+----+---------------------------+-----------------------+%n");

		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getEmail(), user.getFullName());
		}
		System.out.format("+----+---------------------------+-----------------------+%n");
	}

	private void getMenberByProjectID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID của Project: ");
		int id = ScannerUltis.inputIntPositive();
		List<User> list = new ArrayList<User>();
		list = userControler.getManagerInProjects(id);

		String leftAlignFormat = "| %-2d | %-25s | %-21s |%n";
		System.out.format("+----+---------------------------+-----------------------+%n");
		System.out.format("|ID  | Email                     |   FullName            |%n");
		System.out.format("+----+---------------------------+-----------------------+%n");

		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getEmail(), user.getFullName());
		}
		System.out.format("+----+---------------------------+-----------------------+%n");
	}
}
