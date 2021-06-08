package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vti.DAO.AccountDAO;
import com.vti.DAO.DepartmentDAO;
import com.vti.DAO.PositionDAO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

public class Exercise2_q8 {
	private AccountDAO accDAO;
	Scanner sc = new Scanner(System.in);

	public Exercise2_q8() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		accDAO = new AccountDAO();
		menu();
	}

	private void menu() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. In ra các Account");
			System.out.format(leftAlign, "2. Thông tin Account có ID = 5");
			System.out.format(leftAlign, "3. Thông tin Account có ID = ? ");
			System.out.format(leftAlign, "4. Kiểm tra tên Account có tổn tại không?");
			System.out.format(leftAlign, "5. Tạo 1 Account mới");
			System.out.format(leftAlign, "6. Update Account");
			System.out.format(leftAlign, "7. Xoá Account");
			System.out.format(leftAlign, "8. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 8, "Nhập lại");
			switch (choose) {
			case 1:
				question1();
				break;
			case 2:
				question2();
				break;
			case 3:
				question3();
				break;
			case 4:
				question4();
				break;
			case 5:
				question5();
				break;
			case 6:
				question6();
				break;
			case 7:
				question7();
				break;
			case 8:
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

	public void question1() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Danh sach cac department: ");
		List<Account> listAcc = accDAO.getListAccount();

		String leftAlignFormat = "| %-6d | %-20s | %-13s | %-13s | %-13s | %-13s | %-13s |%n";
		System.out.format(
				"+---------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"| ID     | Email	 	| UserName	| FullName	| Department	| Position	| CreateDate	|%n");
		System.out.format(
				"+--------+----------------------+---------------+---------------+---------------+---------------+---------------+%n");

		for (Account account : listAcc) {
			System.out.format(leftAlignFormat, account.getAccountId(), account.getEmail(), account.getUserName(),
					account.getFullName(), account.getDep(), account.getPos(), account.getCreateDate());
		}
		System.out.format(
				"+---------------------------------------------------------------------------------------------------------------+%n");
	}

	public void question2() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Thong tin Account co ID = 5");
		Account accQues2 = accDAO.getAccounttById(5);
		if (accQues2 != null) {
			String leftAlignFormat = "| %-6d | %-20s | %-13s | %-13s | %-13s | %-13s | %-13s |%n";
			System.out.format(
					"+---------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"| ID     | Email	 	| UserName	| FullName	| Department	| Position	| CreateDate	|%n");
			System.out.format(
					"+--------+----------------------+---------------+---------------+---------------+---------------+---------------+%n");

			System.out.format(leftAlignFormat, accQues2.getAccountId(), accQues2.getEmail(), accQues2.getUserName(),
					accQues2.getFullName(), accQues2.getDep(), accQues2.getPos(), accQues2.getCreateDate());
			System.out.format(
					"+---------------------------------------------------------------------------------------------------------------+%n");

		} else {
			System.out.println("Khong ton tai");
		}

	}

	public void question3() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int id = ScannerUltis.inputIntPositive();
		Account accQues2 = accDAO.getAccounttById(id);
		if (accQues2 != null) {
			String leftAlignFormat = "| %-6d | %-20s | %-13s | %-13s | %-13s | %-13s | %-13s |%n";
			System.out.format(
					"+---------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"| ID     | Email	 	| UserName	| FullName	| Department	| Position	| CreateDate	|%n");
			System.out.format(
					"+--------+----------------------+---------------+---------------+---------------+---------------+---------------+%n");

			System.out.format(leftAlignFormat, accQues2.getAccountId(), accQues2.getEmail(), accQues2.getUserName(),
					accQues2.getFullName(), accQues2.getDep(), accQues2.getPos(), accQues2.getCreateDate());
			System.out.format(
					"+---------------------------------------------------------------------------------------------------------------+%n");

		} else {
			System.out.println("Khong ton tai");
		}

	}

	public void question4() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Kiem tra ten account co ton tai khong");
		System.out.println("Nhap FullName: ");
		String name = ScannerUltis.inputString();
		Boolean check = accDAO.isAccountExists(name);
		if (check) {
			System.out.println(name.toUpperCase() + " da co tren he thong");
			question1();
		} else {
			System.out.println("Ten nay chua co tren he thong");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
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
//		System.out.println("Ngay tao (yyyy-MM-dd:)");
//		String createDate = ScannerUltis.inputString();

		if (accDAO.createAcc(acc, depId, posId)) {
			System.out.println("Tao thanh cong");
			question1();
		} else {
			System.out.println("khong thanh cong");
		}

	}

	private int getPos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			PositionDAO posDAO = new PositionDAO();
			List<Position> listPos = posDAO.getListPosition();

			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | PositionName		 |%n");
			System.out.format("+--------+-----------------------+%n");

			for (Position position : listPos) {
				System.out.format(leftAlignFormat, position.getPositionId(), position.getPositionName());
			}
			System.out.format("+--------+-----------------------+%n");
			int chosse = ScannerUltis.inputIntPositive();

			if (posDAO.getPositionById(chosse) != null) {
				return chosse;
			} else {
				System.out.println("Chon lai!");
			}

		}
	}

	private int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentDAO depDAO = new DepartmentDAO();
			List<Department> listDep = depDAO.getListDepartment();

			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | DepartmentName	 |%n");
			System.out.format("+--------+-----------------------+%n");

			for (Department dep : listDep) {
				System.out.format(leftAlignFormat, dep.getId(), dep.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			int chosse = ScannerUltis.inputIntPositive();

			if (depDAO.getDepartmentById(chosse) != null) {
				return chosse;
			} else {
				System.out.println("Chon lai!");
			}
		}
	}

	public void question6() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Cap nhat ten nhan vien qua ID");
		int id = getIdUpdate();
		System.out.println("Nhap vao ten moi: ");
		String newName = ScannerUltis.inputString();
		if (accDAO.updateAccountName(id, newName)) {
			System.out.println("Update thanh cong");
			question1();
		} else {
			System.out.println("Update khong thanh cong");
		}
	}

	private int getIdUpdate() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			System.out.println("Nhap ID nhan vien can update: ");
			int id = ScannerUltis.inputIntPositive();
			Account acc = accDAO.getAccounttById(id);
			if (acc == null) {
				System.out.println("Khong co nhan vien nao co ID la " + id);
			} else {
				return id;
			}
		}
	}

	public void question7() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		int id = getIdDel();
		if (accDAO.deleteDepById(id)) {
			System.out.println("Xoa thanh cong department co id la " + id);
			question1();
		} else {
			System.out.println("Xoa khong thanh cong");
		}
	}

	private int getIdDel() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.println("Nhap ID account can xoa: ");
			int id = ScannerUltis.inputIntPositive();
			Account acc = accDAO.getAccounttById(id);
			if (acc == null) {
				System.out.println("Account khong ton tai");
			} else {
				return id;
			}
		}
	}

}
