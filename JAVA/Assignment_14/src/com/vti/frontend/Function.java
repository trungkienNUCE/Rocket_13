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

	public void islogin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào Password: ");
		String pass = ScannerUltis.inputPassword();

		User user = userControler.isLogin(email, pass);
		if (user != null) {
			if (userControler.isAdmin(user)) {
				showMenuUser();
			} else {
				showmenuAdmin();
			}
		} else {
			System.out.println("Đã có lỗi xảy ra!!");
		}

	}

	private void showMenuUser() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tìm thành viên của Project theo ID");
			System.out.format(leftAlignFormat, "2. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				getMenberByProjectID();
				break;
			case 2:

				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}

	private void showmenuAdmin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tạo User mới");
			System.out.format(leftAlignFormat, "2. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				createNewUser();
				break;
			case 2:

				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}

	private void createNewUser() throws ClassNotFoundException, SQLException {
		User user = new User();
		System.out.println("Nhập vào Email: ");
		user.setEmail(ScannerUltis.inputEmail());
		System.out.println("Nhập vào FullName: : ");
		user.setFullName(ScannerUltis.inputString());
		if (userControler.createAccount(user)) {
			System.out.println("Tạo thành công: ");
			System.out.println("Thông tin tài khoản mới tạo user: " + user.getEmail() + " Pass: 123456A");
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}

	}

	private void getMenberByProjectID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào tên của Project: ");
		String nameProject = ScannerUltis.inputString();
		List<User> list = new ArrayList<User>();
		list = userControler.getManagerInProjects(nameProject);

		String leftAlignFormat = "| %-2d | %-25s | %-21s | %-21s |%n";
		System.out.format("+----+---------------------------+-----------------------+%n");
		System.out.format("|ID  | Email                     |   FullName            |%n");
		System.out.format("+----+---------------------------+-----------------------+%n");

		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getEmail(), user.getFullName());
		}
		System.out.format("+----+---------------------------+-----------------------+%n");
	}
	

}
