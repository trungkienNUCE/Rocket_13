//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presertationlayer.AdminController;
import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;
import com.vti.ultis.ScannerUltis;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class AdminFunction {
	Scanner sc = new Scanner(System.in);

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	static void menuAdmin() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    HỆ THỐNG QUẢN LÝ ỨNG VIÊN	   	  |%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Xem danh sách các dự án");
			System.out.format(leftAlign, "2. Tìm nhân viên qua địa chỉ Email");
			System.out.format(leftAlign, "3. Thêm dự án mới");
			System.out.format(leftAlign, "4. Thêm nhân viên mới");
			System.out.format(leftAlign, "5. Thêm nhân viên vào dự án");
			System.out.format(leftAlign, "6. Xem thành viên trong dự án");
			System.out.format(leftAlign, "7. Xem các quản lý trong dự án");
			System.out.format(leftAlign, "8. Trở lại");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 8, "Nhập lại");
			switch (choose) {
			case 1:
//				xem danh sach du an
				AdminFunction.getListProject();
				break;
			case 2:
//				lay thong tin nv qua email
//				AdminFunction.getListAccByIdAcc();
				AdminFunction.getListAccByEmail();
				break;
			case 3:
//				tham du an moi
				AdminFunction.insertProject();
				break;
			case 4:
//				them nhan vien moi
				AdminFunction.insertAccount();
				break;
			case 5:
//				them nhan vien vao du an
				AdminFunction.addAccInProject();
				break;
			case 6:
//				Xem cac thanh vien trong du an
				AdminFunction.getListAccByIdProject();
				break;
			case 7:
//				xem cac quan ly trong du an
				AdminFunction.getListManagerByIdProject();
				break;
			case 8:
				Program.main(null);
				break;
			default:
				System.out.println("Nhập lại");
				return;
			}
		}

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void updatePassword() {
		System.out.println("Đổi mật khẩu cho nhân viên");

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void insertProject() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập tên dự án: ");
		String projectName = ScannerUltis.inputString();
		System.out.println("Nhập team size: ");
		int teamSize = ScannerUltis.inputIntPositive();

		AdminController adminControler = new AdminController();
		Project project = new Project(projectName, teamSize);

		if (adminControler.createProject(project)) {
			System.out.println("Thêm thành công");
			getListProject();
		} else {
			System.out.println("Không thành công");
		}

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void addAccInProject()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Danh sách các dự án");
		AdminFunction.getListProject();
		System.out.println("Nhập ID dự án: ");
		int projectId = ScannerUltis.inputIntPositive();
		AdminFunction.getListAcc();
		System.out.println("Nhập ID nhân viên: ");
		int accountId = ScannerUltis.inputIntPositive();
		AdminController adminControler = new AdminController();
		ManageProject mp = new ManageProject(projectId, accountId);

		if (adminControler.addAccInProject(projectId, accountId)) {
			System.out.println("Thêm thành công");
			getListProject();
		} else {
			System.out.println("Không thành công");
		}

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @param <E>
	 * @throws IOException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void getListAccByIdProject()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		AdminController adminControler = new AdminController();
		System.out.println("Xem tất cả các thành viên trong dự án");
		adminControler.getListProject();
		System.out.println("Nhập id dự án");
//		int idProject = ScannerUltis.inputIntPositive();
		int idProject = 1;

//		List<ManageProject> manageProjects = adminControler.getListAccByIdProject(idProject);

		List<Integer> manageProjects = adminControler.getListAccByIdProject(idProject);

		if (manageProjects != null) {
//			for (ManageProject mp : manageProjects) {
//				System.out.println(mp.getAccountId());
//			}
			for (int i = 0; i < manageProjects.size(); i++) {
				System.out.println(manageProjects.get(i));
			}

		} else {
			System.out.println("Không có");
		}

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void getListAccByIdAcc()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AdminController adminController = new AdminController();

//		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int[] id1 = { 1, 2, 3 };

		for (int i = 0; i < id1.length; i++) {
			Account acc = adminController.getListAccByIdAcc(id1[i]);
			System.out.println(acc.toString());

//			System.out.println("Thong tin cac acc co id " + id1[i] + " la: ");
//			String leftAlignFormat = "| %-6d | %-20s | %-13s | %-13s | %-13s | %-13s |%n";
//			System.out.format(
//					"+---------------------------------------------------------------------------------------------------------------+%n");
//			System.out.format("| ID     | FullName	 | Email	| Pass	| Kinh nghiem	| Skill	|%n");
//			System.out.format(
//					"+--------+----------------------+---------------+---------------+---------------+---------------+---------------+%n");
//
//			System.out.format(leftAlignFormat, acc.getId(), acc.getFullName(), acc.getEmail(), acc.getPassWord(),
//					acc.getExpInYear(), acc.getProSkill());
//			System.out.format(
//					"+---------------------------------------------------------------------------------------------------------------+%n");

		}

	}

	public static void isIdProjectExists(int idProject)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		AdminController adminControler = new AdminController();
		System.out.println("Nhap id: ");
		int idProject2 = ScannerUltis.inputIntPositive();
		Boolean check = adminControler.isIdProjectExists(idProject2);

		if (check) {
			System.out.println("Du an ban da ton tai");
		} else {
			System.out.println("Phong ban chua co tren he thong");
		}
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void getListManagerByIdProject() {
		System.out.println("Xem các quản lý trong dự án");
		System.out.println("Danh sách dự án");
		System.out.println("Nhập id dự án");
		System.out.println("Thông tin các account là");

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 12, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 12, 2021
	 */
	public static void getListProject()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AdminController adminController = new AdminController();
		List<Project> listProject = adminController.getListProject();

		System.out.println("Thong tin cac du an la la: ");

		String leftAlignFormat = "| %-6d | %-21s |%-10d |%n";
		System.out.format("+--------+-----------------------------------+%n");
		System.out.format("| ID     | Ten du an	 	 |Teamsize   |%n");
		System.out.format("+--------+-----------------------+-----------+%n");

		for (Project pro : listProject) {
			System.out.format(leftAlignFormat, pro.getId(), pro.getName(), pro.getTeamSize());
		}
		System.out.format("+--------------------------------------------+%n");

	}

	public static void getListAcc() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AdminController adminController = new AdminController();
		List<Account> listAcc = adminController.getListAcc();

		Account acc = new Account();

		String leftAlignFormat = "| %-6d | %-20s | %-20s | %-13s | %-13s | %-13s |%n";
		System.out.format(
				"+------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"| ID     | FullName	 	| Email		       | Pass	       | Kinh nghiem   | Skill	       |%n");
		System.out.format(
				"+--------+----------------------+----------------------+---------------+---------------+---------------+%n");

		System.out.format(leftAlignFormat, acc.getId(), acc.getFullName(), acc.getEmail(), acc.getPassWord(),
				acc.getExpInYear(), acc.getProSkill());
		System.out.format(
				"+------------------------------------------------------------------------------------------------------+%n");
		for (Account account : listAcc) {
			System.out.format(leftAlignFormat, account.getId(), account.getFullName(), account.getEmail(),
					account.getPassWord(), account.getExpInYear(), account.getProSkill());
			;
		}

		System.out.format("+--------------------------------------------+%n");

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 14, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 14, 2021
	 */
	public static void insertAccount() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.format("|	    THÊM NHÂN VIÊN	   	  		|%n");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Thêm quản lý");
			System.out.format(leftAlign, "2. Thêm nhân viên");
			System.out.format(leftAlign, "3. Trở lại");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				System.out.println("Thêm quản lý mới");
				System.out.println("Nhập Fullname: ");
				String fullName = ScannerUltis.inputString();
				System.out.println("Nhập Email: ");
				String email = ScannerUltis.inputEmail();
				System.out.println("Số năm kinh nghiệm: ");
				int expInYear = ScannerUltis.inputIntPositive();
				System.out.println("Ký năng chuyên môn: ");
				String proSkill = ScannerUltis.inputString();

				AdminController adminControler = new AdminController();
				Account acc = new Account(fullName, email, expInYear, proSkill);

				if (adminControler.createAcc(acc)) {
					System.out.println("Thêm thành công quản lý: " + fullName);
					System.out.println(
							"Chú ý: mật khẩu mặc định là '12345A', quản lý đổi mật khẩu trong lần đăng nhập đầu tiên");
				} else {
					System.out.println("Không thành công");
				}

				break;
			case 2:
				System.out.println("Thêm nhân viên mới");
				System.out.println("Nhập Fullname: ");
				String fullName1 = ScannerUltis.inputString();
				System.out.println("Nhập Email: ");
				String email1 = ScannerUltis.inputEmail();

				AdminController adminControler1 = new AdminController();
				Account acc1 = new Account(fullName1, email1);

				if (adminControler1.createAcc(acc1)) {
					System.out.println("Thêm thành công nhân viên: " + fullName1);
					System.out.println(
							"Chú ý: mật khẩu mặc định là '12345A', nhân viên đổi mật khẩu trong lần đăng nhập đầu tiên");
				} else {
					System.out.println("Không thành công");
				}
				break;
			case 3:
				AdminFunction.menuAdmin();
				break;
			default:
				return;
			}
		}

	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 14, 2021
	 * @version: 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 14, 2021
	 */
	public static void getListAccByEmail()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tìm nhân viên qua địa chỉ Email");
		System.out.println("Nhập Email: ");
		String email = ScannerUltis.inputEmail();
		AdminController adminController = new AdminController();

		Account acc = adminController.getListAccByEmail(email);
		if (acc != null) {
			System.out.println("Thông tin nhân viên có email " + email + " la: ");
			String leftAlignFormat = "| %-6d | %-20s | %-20s | %-13s | %-13s | %-13s |%n";
			System.out.format(
					"+------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"| ID     | FullName	 	| Email		       | Pass	       | Kinh nghiem   | Skill	       |%n");
			System.out.format(
					"+--------+----------------------+----------------------+---------------+---------------+---------------+%n");

			System.out.format(leftAlignFormat, acc.getId(), acc.getFullName(), acc.getEmail(), acc.getPassWord(),
					acc.getExpInYear(), acc.getProSkill());
			System.out.format(
					"+------------------------------------------------------------------------------------------------------+%n");

		} else {
			System.out.println("Email không tồn tại");
		}

	}

}
