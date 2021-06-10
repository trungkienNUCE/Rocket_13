//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.presertationlayer.AccountController;
import com.vti.backend.presertationlayer.DepartmentController;
import com.vti.backend.presertationlayer.PositionController;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

/**
 * This class is demo function of account
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class AccountFunction {
	Scanner sc = new Scanner(System.in);

	/**
	 * This method is used update account
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
	public static void updateAccount() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accController = new AccountController();
		DepartmentController depController = new DepartmentController();
		while (true) {
			switch (menuQues6()) {
			case 1:
				System.out.println("Update Email nha");
				int id = getIdCase1();
				System.out.println("Nhao vao Email moi: ");
				String newEmail = ScannerUltis.inputEmail();
				if (accController.updateByEmail(id, newEmail)) {
					System.out.println("Update email thanh cong");
				} else {
					System.out.println("Khong thanh cong");
				}

				break;
			case 2:
				System.out.println("Update Username nha");
				int id2 = getIdCase1();
				System.out.println("Nhao vao Username moi: ");
				String newUserName = ScannerUltis.inputString();
				if (accController.updateByEmail(id2, newUserName)) {
					System.out.println("Update username thanh cong");
				} else {
					System.out.println("Khong thanh cong");
				}

				break;
			case 3:
				System.out.println("Update Fullname nha");
				int id3 = getIdCase1();
				System.out.println("Nhao vao Fullname moi: ");
				String newFullName = ScannerUltis.inputEmail();
				if (accController.updateByEmail(id3, newFullName)) {
					System.out.println("Update Fullname thanh cong");
				} else {
					System.out.println("Khong thanh cong");
				}

				break;
			case 4:
				System.out.println("Update Department nha");
				int id4 = getIdCase1();
				int idDep = getNewIdDep();
				if (accController.updateByDepId(id4, idDep)) {
					System.out.println("Update Department thanh cong");
				} else {
					System.out.println("Khong thanh cong");
				}

				break;
			case 5:
				System.out.println("Update Position nha");
				int id5 = getIdCase1();
				int idPos = getNewIdPos();
				if (accController.updateByPosId(id5, idPos)) {
					System.out.println("Update Department thanh cong");
				} else {
					System.out.println("Khong thanh cong");
				}

				break;
			case 6:
				return;

			}
		}
	}

	/**
	 * This method is input new id position
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static int getNewIdPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		PositionController possitionControler = new PositionController();
		System.out.println("Chọn Position:");

		while (true) {
			List<Position> listpos = possitionControler.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Position Name |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getPositionId(), position.getPositionName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn ID của Position cần Update:");
			int id = ScannerUltis.inputIntPositive();
			if (possitionControler.getPosById(id) != null) {
				return id;
			} else {
				System.out.println("Không có Position này, hãy nhập lại: ");
			}
		}
	}

	/**
	 * This method is input new id department
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static int getNewIdDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		System.out.println("Chọn phòng");
		while (true) {
			List<Department> listDep = departmentController.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Depament Name |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn ID của phòng cần Update:");
			int id = ScannerUltis.inputIntPositive();
			if (departmentController.getDepById(id) != null) {
				return id;
			} else {
				System.out.println("Không có phòng này, hãy nhập lại: ");
			}
		}
	}

	/**
	 * This method is input accountid
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static int getIdCase1() throws FileNotFoundException, IOException {
		while (true) {
			System.out.println("Nhập vào ID của account cần Update: ");
			int id = ScannerUltis.inputIntPositive();
			AccountController accountControler = new AccountController();
			if (accountControler.getAccountByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có account này trên hệ thống, Nhập lại: ");
			}
		}
	}

	/**
	 * This method is menu of question 6(update account)
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 */
	private static int menuQues6() {
		while (true) {
			System.out.println("Ban muon update truong nao?");
			System.out.println("1. Email, 2. Username, 3. Fullname, 4. Department, 5. Position, 6 Exit");
			int i = ScannerUltis.inputFunction(1, 6, "Nhap lai: ");
			return i;

		}
	}

	/**
	 * This method is used print all account
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void getListAllAccount()
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		AccountController accountControler = new AccountController();
		List<Account> listAcc = accountControler.getListAcc();
		System.out.println("Thong tin cac Account la: ");
		String leftAlignFormat = "| %-6d | %-20s | %-13s | %-13s | %-13s | %-13s | %-13s |%n";
		System.out.format(
				"+---------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"| ID     | Email	 	| UserName	| FullName	| Department	| Position	| CreateDate	|%n");
		System.out.format(
				"+--------+----------------------+---------------+---------------+---------------+---------------+---------------+%n");

		for (Account account : listAcc) {
			System.out.format(leftAlignFormat, account.getAccountId(), account.getEmail(), account.getUserName(),
					account.getFullName(), account.getDepartment(), account.getPosition(), account.getCreateDate());
		}
		System.out.format(
				"+---------------------------------------------------------------------------------------------------------------+%n");
	}

	public static void getAccountByID()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int idFind = ScannerUltis.inputIntPositive();
		AccountController accountControler = new AccountController();
		Account accQues2 = accountControler.getAccountByID(idFind);
		System.out.println("Thong tin cua account co id " + idFind + " la");
		if (accQues2 != null) {
			String leftAlignFormat = "| %-6d | %-20s | %-13s | %-13s | %-13s | %-13s | %-13s |%n";
			System.out.format(
					"+---------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"| ID     | Email	 	| UserName	| FullName	| Department	| Position	| CreateDate	|%n");
			System.out.format(
					"+--------+----------------------+---------------+---------------+---------------+---------------+---------------+%n");

			System.out.format(leftAlignFormat, accQues2.getAccountId(), accQues2.getEmail(), accQues2.getUserName(),
					accQues2.getFullName(), accQues2.getDepartment(), accQues2.getPosition(), accQues2.getCreateDate());
			System.out.format(
					"+---------------------------------------------------------------------------------------------------------------+%n");

		} else {
			System.out.println("Khong ton tai");
		}

	}

	/**
	 * This method is check account name has exists?
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void isAccNameExists()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Kiem tra ten account co ton tai khong");
		System.out.println("Nhap FullName: ");
		String name = ScannerUltis.inputString();
		AccountController accController = new AccountController();
//		Account acc = accController.isAccNameExists(name);

		if (accController.isAccNameExists(name)) {
			System.out.println(name.toUpperCase() + " da co tren he thong");
			getListAllAccount();
		} else {
			System.out.println("Ten nay chua co tren he thong");
		}
	}

	/**
	 * This method is create account
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void createAccount() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tao account moi");
		Account acc = new Account();
		System.out.println("Nhap Email: ");
		acc.setEmail(ScannerUltis.inputEmail());

		System.out.println("Nhap UserName: ");
		acc.setUserName(ScannerUltis.inputString());

		System.out.println("Nhap FullName: ");
		acc.setFullName(ScannerUltis.inputString());

		System.out.println("Chon phong nhan vien: ");
		int depId = getDep();

		System.out.println("Chon vi tri nhan vien: ");
		int posId = getPos();
		AccountController accController = new AccountController();

		if (accController.createAcc(acc, depId, posId)) {
			System.out.println("Tao thanh cong");
			getListAllAccount();
		} else {
			System.out.println("khong thanh cong");
		}

	}

	/**
	 * This method is get id of position
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private static int getPos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			PositionController posController = new PositionController();
			List<Position> listPos = posController.getListPosition();

			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | PositionName	 |%n");
			System.out.format("+--------+-----------------------+%n");

			for (Position pos : listPos) {
				System.out.format(leftAlignFormat, pos.getPositionId(), pos.getPositionName());
			}
			System.out.format("+--------+-----------------------+%n");

			System.out.println("Chon vi tri theo ID:");
			int chosse = ScannerUltis.inputIntPositive();

			if (posController.getPosById(chosse) != null) {
				return chosse;
			} else {
				System.out.println("Chon lai!");
			}
		}
	}

	/**
	 * This method is get id of department
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static int getDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			DepartmentController depController = new DepartmentController();
			List<Department> listDep = depController.getListDepartment();

			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | DepartmentName |%n");
			System.out.format("+--------+-----------------------+%n");

			for (Department dep : listDep) {
				System.out.format(leftAlignFormat, dep.getId(), dep.getName());
			}
			System.out.format("+--------+-----------------------+%n");

			System.out.println("Chon phong theo ID:");
			int chosse = ScannerUltis.inputIntPositive();

			if (depController.getDepById(chosse) != null) {
				return chosse;
			} else {
				System.out.println("Chon lai!");
			}
		}
	}

	public static void deleteById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		AccountController accController = new AccountController();
		int id = getIdDel();
		if (accController.delAccById(id)) {
			System.out.println("Xoa thanh cong");
		} else {
			System.out.println("Xoa khong thanh cong");
		}
	}

	/**
	 * This method is used search account to delete
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static int getIdDel() throws FileNotFoundException, IOException {
		AccountController accController = new AccountController();
		while (true) {
			System.out.println("Nhap vao ID Account can xoa:");
			int id = ScannerUltis.inputIntPositive();
			if (accController.getAccountByID(id) != null) {
				return id;
			} else {
				System.out.println("Khong co account nay tren he thong. Nhap lai: ");
			}

		}
	}

}
