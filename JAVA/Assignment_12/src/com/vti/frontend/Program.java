//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.presertationlayer.ExperienceCandidateController;
import com.vti.backend.presertationlayer.FresherCandidateController;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.ultis.ScannerUltis;

/**
 * This class is used run program
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class Program {
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		menu();
	}

	/**
	 * This method is menu main
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void menu() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    HỆ THỐNG QUẢN LÝ ỨNG VIÊN	   	  |%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Đăng ký");
			System.out.format(leftAlign, "2. Đăng nhập");
			System.out.format(leftAlign, "3. Thoát");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				menuRegister();
				break;
			case 2:
				menuLogin();
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
				System.out.println("Nhập lại: ");
				return;
			}
		}

	}

	/**
	 * This method is menu dang nhap
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void menuLogin() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    ĐĂNG NHẬP VÀO HỆ THỐNG	   	  |%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Bạn là? 			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Ứng viên đã có kinh nghiệm");
			System.out.format(leftAlign, "2. Ứng viên mới tốt nghiệp");
			System.out.format(leftAlign, "3. Trở lại");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				loginExperienceCandidate();
				break;
			case 2:
				loginFresherCandidate();
				break;
			case 3:
				menu();
				break;
			default:
				return;
			}
		}

	}

	/**
	 * This method is dang nhap voi vai tro ung vien moi tot nghiem
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void loginFresherCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập Username: ");
		String userName = ScannerUltis.inputString();
		System.out.println("Nhập mật khẩu: ");
		String password = ScannerUltis.inputString();

		FresherCandidateController fresherCanContr = new FresherCandidateController();
		if (fresherCanContr.login(userName, password)) {
			System.out.println("Đăng nhập thành công");
			menuFuntion2();
		} else {
			System.out.println("Đăng nhập không thành công");
		}

	}

	/**
	 * This method is dang nhap voi vai tro la ung vien co kinh nghiem
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void loginExperienceCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập Username: ");
		String userName = ScannerUltis.inputString();
		System.out.println("Nhập mật khẩu: ");
		String password = ScannerUltis.inputString();

		ExperienceCandidateController expCanContr = new ExperienceCandidateController();
		if (expCanContr.login(userName, password)) {
			System.out.println("Đăng nhập thành công");
			menuFuntion();
		} else {
			System.out.println("Đăng nhập không thành công");
		}
	}

	/**
	 * This method is menu chuc nang
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void menuFuntion2() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    HỆ THỐNG QUẢN LÝ ỨNG VIÊN	   	  |%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Xem thông tin tài khoản");
			System.out.format(leftAlign, "2. Đổi mật khẩu");
			System.out.format(leftAlign, "3. Trở lại");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				System.out.println("Đang cập nhật...");
				break;
			case 2:
				updateFresherCandidate();
				break;
			case 3:
				menu();
				break;
			default:
				System.out.println("Nhập lại");
				return;
			}
		}

	}

	/**
	 * This method is doi mat khau cho fresher
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void updateFresherCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đổi mật khẩu!!!");
		System.out.println("Nhập email: ");
		String email = ScannerUltis.inputString();
		System.out.println("Nhập mật khẩu mới: ");
		String password = ScannerUltis.inputPassword();

		FresherCandidateController fresherCanContr = new FresherCandidateController();

		if (fresherCanContr.updateExperienceCandidate(password, email)) {
			System.out.println("Đổi mật khẩu thành công");
		} else {
			System.out.println("Không thành công");
		}

	}

	/**
	 * This method is menu chuc nang
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void menuFuntion() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    HỆ THỐNG QUẢN LÝ ỨNG VIÊN	   	  |%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Xem thông tin tài khoản");
			System.out.format(leftAlign, "2. Đổi mật khẩu");
			System.out.format(leftAlign, "3. Trở lại");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				System.out.println("Đang cập nhật...");
				break;
			case 2:
				updateExperienceCandidate();
				break;
			case 3:
				menu();
				break;
			default:
				System.out.println("Nhập lại");
				return;
			}
		}
	}

	/**
	 * This method is doi mat khau cho ung vien co kinh nghiem
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 11, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 11, 2021
	 */
	private static void updateExperienceCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đổi mật khẩu!!!");
		System.out.println("Nhập email: ");
		String email = ScannerUltis.inputString();
		System.out.println("Nhập mật khẩu mới: ");
		String password = ScannerUltis.inputPassword();

		ExperienceCandidateController expCanContr = new ExperienceCandidateController();

		if (expCanContr.updateExperienceCandidate(password, email)) {
			System.out.println("Đổi mật khẩu thành công");
		} else {
			System.out.println("Không thành công");
		}

	}

	/**
	 * This method is menu dang ky tai khoan
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void menuRegister() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    ĐĂNG KÝ TÀI KHOẢN MỚI	   	  |%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Bạn là?			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Ứng viên đã có kinh nghiệm");
			System.out.format(leftAlign, "2. Ứng viên mới tốt nghiệp");
			System.out.format(leftAlign, "3. Trở về");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				insertExperienceCandidate();
				break;
			case 2:
				insertFresherCandidate();
				break;
			case 3:
				menu();
				break;
			default:
				System.out.println("Nhập lại");
				return;
			}
		}

	}

	/**
	 * This method is them moi ung vien moi tot nghiep
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void insertFresherCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập thông tin username: ");
		String userName = ScannerUltis.inputString();
		System.out.println("Nhập FullName: ");
		String fullName = ScannerUltis.inputString();
		System.out.println("Nhập số điện thoại: ");
		String phone = ScannerUltis.inputPhoneNumber();
		System.out.println("Nhập Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println(
				"Chú ý: Mật khẩu phải có 6 đến 12 ký tự gồm các chữ cái a đến z, trong đó có ít nhất 1 ký tự viết hoa");
		System.out.println("Nhập mật khẩu: ");
		String password = ScannerUltis.inputPassword();
		System.out.println("Xếp loại tốt nghiệp: 1. Excellence, 2.Good, 3.Fair, 4.Poor ");
		String GraduationRank = getGraduationRank();

		FresherCandidateController fresherCanContr = new FresherCandidateController();

		if (fresherCanContr.insertFresherCandidate(userName, fullName, phone, email, password, GraduationRank)) {
			System.out.println("Tài khoản: " + userName + " tạo thành công với mật khẩu là: " + password);
		} else {
			System.out.println("Lỗi");
		}

	}

	/**
	 * This method is lay xep loai tot nghiep
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 */
	private static String getGraduationRank() {
		while (true) {
			switch (ScannerUltis.inputFunction(1, 4, "Nhập lại")) {
			case 1:
				return "Excellence";
			case 2:
				return "Good";
			case 3:
				return "Fair";
			case 4:
				return "Poor";
			default:
				System.out.println("Nhap lai");
			}

		}
	}

	/**
	 * This method is them ung vien co kinh nghiem
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void insertExperienceCandidate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập thông tin username: ");
		String userName = ScannerUltis.inputString();
		System.out.println("Nhập FullName: ");
		String fullName = ScannerUltis.inputString();
		System.out.println("Nhập số điện thoại: ");
		String phone = ScannerUltis.inputPhoneNumber();
		System.out.println("Nhập Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Nhập mật khẩu: ");
		String password = ScannerUltis.inputPassword();
		System.out.println("Nhập số năm kinh nghiệm: ");
		int expInYear = ScannerUltis.inputFunction(1, 10, "Nhập lại số năm từ 1 đến 10");
		System.out.println("Nhập kỹ năng chuyên môn: ");
		String proSkill = ScannerUltis.inputString();

		ExperienceCandidateController expCanContr = new ExperienceCandidateController();
		if (expCanContr.insertExperienceCandidate(userName, fullName, phone, email, password, expInYear, proSkill)) {
			System.out.println("Tài khoản: " + userName + " tạo thành công với mật khẩu là: " + password);
		} else {
			System.out.println("Lỗi");
		}

	}

}
