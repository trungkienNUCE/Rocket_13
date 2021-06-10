//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

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
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Quan ly nhan vien (Account)");
			System.out.format(leftAlign, "2. Quan ly phong ban (Department)");
			System.out.format(leftAlign, "3. Quan ly vi tri (Position)");
			System.out.format(leftAlign, "4. Quan ly nhom (Group)");
			System.out.format(leftAlign, "5. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 7, "Nhập lại");
			switch (choose) {
			case 1:
				getMenuAccount();
				break;
			case 2:
				getMenuDep();
				break;
			case 3:
				getMenuPos();
				break;
			case 4:
				getMenuGroup();
				break;
			case 5:
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

	/**
	 * This method is menu group 
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void getMenuGroup() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. In ra các Group");
			System.out.format(leftAlign, "2. Thông tin Group có ID nhập vào");
			System.out.format(leftAlign, "3. Kiểm tra tên Group có tổn tại không?");
			System.out.format(leftAlign, "4. Tạo 1 Group mới");
			System.out.format(leftAlign, "5. Update Group");
			System.out.format(leftAlign, "6. Xoá Group");
			System.out.format(leftAlign, "7. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 7, "Nhập lại");
			switch (choose) {
			case 1:
				GroupFunction.getListGroup();
				break;
			case 2:
				GroupFunction.getGroupById();
				break;
			case 3:
				GroupFunction.isGroupExists();
				break;
			case 4:
				GroupFunction.createGroup();
				break;
			case 5:
				GroupFunction.updateGroup();
				break;
			case 6:
				GroupFunction.delGroupById();
				break;
			case 7:
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

	/**
	 * This method is menu position 
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void getMenuPos() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. In ra các Position");
			System.out.format(leftAlign, "2. Thông tin Position có ID nhập vào");
			System.out.format(leftAlign, "3. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 3, "Nhập lại");
			switch (choose) {
			case 1:
				PositionFunction.getListPosition();
				break;
			case 2:
				PositionFunction.getDepById();
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
				System.out.println("Nhập lại");
				break;
			}
		}
	}

	/**
	 * This method is menu department
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void getMenuDep() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. In ra các Department");
			System.out.format(leftAlign, "2. Thông tin Department có ID nhập vào");
			System.out.format(leftAlign, "3. Kiểm tra tên Department có tổn tại không?");
			System.out.format(leftAlign, "4. Tạo 1 Department mới");
			System.out.format(leftAlign, "5. Update Department");
			System.out.format(leftAlign, "6. Xoá Department");
			System.out.format(leftAlign, "7. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 7, "Nhập lại");
			switch (choose) {
			case 1:
				DepartmentFunction.getListDepartment();
				break;
			case 2:
				DepartmentFunction.getDepById();
				break;
			case 3:
				DepartmentFunction.isDepartmentNameExists();
				break;
			case 4:
				DepartmentFunction.createDep();
				break;
			case 5:
				DepartmentFunction.updateDepartmentName();
				break;
			case 6:
				DepartmentFunction.delDepById();
				break;
			case 7:
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

	/**
	 * This method is menu account
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 */
	private static void getMenuAccount() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. In ra các Account");
			System.out.format(leftAlign, "2. Thông tin Account có ID nhập vào");
			System.out.format(leftAlign, "3. Kiểm tra tên Account có tổn tại không?");
			System.out.format(leftAlign, "4. Tạo 1 Account mới");
			System.out.format(leftAlign, "5. Update Account");
			System.out.format(leftAlign, "6. Xoá Account");
			System.out.format(leftAlign, "7. Thoát khỏi chương trình");
			System.out.format("+-------------------------------------------------+%n");
			choose = ScannerUltis.inputFunction(1, 7, "Nhập lại");
			switch (choose) {
			case 1:
				AccountFunction.getListAllAccount();
				break;
			case 2:
				AccountFunction.getAccountByID();
				break;
			case 3:
				AccountFunction.isAccNameExists();
				break;
			case 4:
				AccountFunction.createAccount();
				break;
			case 5:
				AccountFunction.updateAccount();
				break;
			case 6:
				AccountFunction.deleteById();
				break;
			case 7:
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
}
