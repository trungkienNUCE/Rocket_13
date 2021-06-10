//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presertationlayer.DepartmentController;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

/**
 * This class is function of Department
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class DepartmentFunction {
	private jdbcUltis jdbc;
	Scanner sc = new Scanner(System.in);

	public static void getListDepartment()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController depController = new DepartmentController();
		List<Department> listDep = depController.getListDepartment();

		System.out.println("Thong tin cac Department la: ");

		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("| ID     | DepartmentName	 |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	/**
	 * This method is used search department by ID
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void getDepById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController depController = new DepartmentController();

		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int id1 = ScannerUltis.inputIntPositive();
		Department dep = depController.getDepById(id1);
		System.out.println("Thong tin cac Department co id " + id1 + " la: ");

		if (dep != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | DepartmentName	 |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, dep.getId(), dep.getName());
			System.out.format("+--------+-----------------------+%n");

		} else {
			System.out.println("Khong ton tai");
		}
	}

	/**
	 * This method is used check department exists?
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void isDepartmentNameExists()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController depController = new DepartmentController();

		System.out.println("Kiem tra phong ban da co tren HT chua? Nhap ten phong: ");
		String depName = ScannerUltis.inputString();
		Boolean check = depController.isDepartmentNameExists(depName);

		if (check) {
			System.out.println("Phong " + depName.toUpperCase() + " ban da ton tai");
		} else {
			System.out.println("Phong ban chua co tren he thong");
		}
	};

	/**
	 * This method is used create new department
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void createDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController depController = new DepartmentController();

		String depName = getDepName();
		if (depController.createDep(depName)) {
			System.out.println("Tao thanh cong");
			getListDepartment();
		} else {
			System.out.println("Da co loi xay ra");
		}

	};

	/**
	 * This method is get new department name
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
	private static String getDepName() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController depController = new DepartmentController();
		while (true) {
			System.out.println("Nhap ten phong moi: ");
			String depName = ScannerUltis.inputString();
			if (depController.isDepartmentNameExists(depName)) {
				System.out.println("Ten phong da co tren he thong");
			} else {
				return depName;
			}
		}

	}

	/**
	 * This method is used update department
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void updateDepartmentName()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController depController = new DepartmentController();
		System.out.println("Nhap ID phong can update: ");
		int depId = getIdUpdate();
		System.out.println("Nhap vao ten moi: ");
		String newName = ScannerUltis.inputString();
		if (depController.updateDepartmentName(depId, newName)) {
			System.out.println("Update phong thanh cong");
		} else {
			System.out.println("Da co loi xay ra");
		}

	};

	/**
	 * This method is get departmentId to update
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
	private static int getIdUpdate() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController depController = new DepartmentController();
		while (true) {
			int id = ScannerUltis.inputIntPositive();
			Department dep = depController.getDepById(id);
			if (dep == null) {
				System.out.println("Khong co ID phong tren HT");
			} else {
				return id;
			}

		}
	}

	/**
	 * This method is used delete department by ID
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void delDepById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController depController = new DepartmentController();
		System.out.println("Nhap Id phong can xoa: ");
		int depId = getIdUpdate();
		if (depController.delDepById(depId)) {
			System.out.println("Xoa phong thanh cong");
		} else {
			System.out.println("Da co loi xay ra");
		}
	}

}
