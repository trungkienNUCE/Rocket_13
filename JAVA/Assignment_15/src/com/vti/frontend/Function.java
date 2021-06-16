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
 * This class is cac chuc nang
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

//	dang nhap va phan quyen
	public void islogin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào Password: ");
		String pass = ScannerUltis.inputPassword();

		User user = userControler.isLogin(email, pass);
		if (user != null) {
			if (userControler.isAdmin(user)) {
				System.out.println("Đăng nhập thành công với vai trò ADMIN");
				showmenuAdmin();
			} else {
				System.out.println("Đăng nhập thành công với vai trò EMPLOYEE");
				showMenuUser();
			}
		} else {
			System.out.println("Đăng nhập không thành công! Thử lại");
		}

	}

//	menu cua user
	private void showMenuUser() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Xem danh sách các User");
			System.out.format(leftAlignFormat, "2. Tìm kiếm User theo ID");
			System.out.format(leftAlignFormat, "3. Thoát");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				getListAllUser();
				break;
			case 2:
				getListUserById();
				break;
			case 3:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}

//	menu cua admin
	private void showmenuAdmin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Xem danh sách các User");
			System.out.format(leftAlignFormat, "2. Tìm kiếm User theo ID");
			System.out.format(leftAlignFormat, "3. Tạo User mới");
			System.out.format(leftAlignFormat, "4. Xoá User theo ID");
			System.out.format(leftAlignFormat, "5. Thoát");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				getListAllUser();
				break;
			case 2:
				getListUserById();
				break;
			case 3:
				createNewUser();
				break;
			case 4:
				delUserById();
				break;
			case 5:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}

	/**
	 * This method is xoa user theo ID
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 15, 2021
	 * @version: 1.0
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 15, 2021
	 */
	public void delUserById() throws ClassNotFoundException, SQLException {
		System.out.println("Xoá User có ID là: ");
		List<User> list = new ArrayList<User>();
		int id = ScannerUltis.inputIntPositive();
		User user = userControler.getUserById(id);

		if (userControler.delUserById(id)) {
			System.out.println("Xoá User thành công");
		} else {
			System.out.println("User không tồn tại!");
		}
	}

	/**
	 * This method is lay user qua id
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 15, 2021
	 * @version: 1.0
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 15, 2021
	 */
	public void getListUserById() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID cuả User: ");
		int id = ScannerUltis.inputIntPositive();
		List<User> list = new ArrayList<User>();
		User user = userControler.getUserById(id);
		if (user != null) {
			String leftAlignFormat = "| %-2d | %-25s | %-21s | %-21s |%n";
			System.out.format("+----+---------------------------+-----------------------+-----------------------+%n");
			System.out.format("|ID  | Email                     |   FullName            |     Role           	 |%n");
			System.out.format("+----+---------------------------+-----------------------+-----------------------+%n");

			System.out.format(leftAlignFormat, user.getId(), user.getEmail(), user.getFullName(), user.getRole());
			System.out.format("+----+---------------------------+-----------------------+-----------------------+%n");
		} else {
			System.out.println("User không tồn tại!");
		}

	}

	/**
	 * This method is lay danh sach tat ca cac user
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 15, 2021
	 * @version: 1.0
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 15, 2021
	 */
	public void getListAllUser() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<User>();
		list = userControler.getListAllUser();
		System.out.println("Danh sách User có trên HT: ");
		String leftAlignFormat = "| %-2d | %-25s | %-21s | %-21s |%n";
		System.out.format("+----+---------------------------+-----------------------+-----------------------+%n");
		System.out.format("|ID  | Email                     |   FullName            |     Role           	 |%n");
		System.out.format("+----+---------------------------+-----------------------+-----------------------+%n");

		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getEmail(), user.getFullName(), user.getRole());
		}
		System.out.format("+----+---------------------------+-----------------------+-----------------------+%n");

	}

	/**
	 * This method is tao user moi
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 15, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 15, 2021
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createNewUser() throws ClassNotFoundException, SQLException {
		User user = new User();
		System.out.println("Tạo User mới");
		System.out.println("Nhập vào Email: ");
		user.setEmail(ScannerUltis.inputEmail());
		System.out.println("Nhập vào FullName: ");
		user.setFullName(ScannerUltis.inputString());

		if (userControler.createAccount(user)) {
			System.out.println("Tạo thành công: ");
			System.out.println("Thông tin tài khoản mới tạo user: " + user.getEmail() + " Pass: 123456A");
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}

	}

}
