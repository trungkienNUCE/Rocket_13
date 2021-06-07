package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vit.DAO.DepartmentDAO;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	private DepartmentDAO depDAO;

	public Exercise2() throws FileNotFoundException, IOException {
		depDAO = new DepartmentDAO();
	}

	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println("Danh sach cac department: ");
		List<Department> listDep1 = depDAO.getListDepartment();

		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("| ID     | DepartmentName	 |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep1) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("Thong tin department co ID = 5");
		Department depQues2 = depDAO.getDepartmentById(5);
		if (depQues2 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | DepartmentName	 |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, depQues2.getId(), depQues2.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Khong ton tai phong nay tren he thong");
		}

	}

	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int id = ScannerUltis.inputIntPositive();
		Department depQues3 = depDAO.getDepartmentById(id);
		if (depQues3 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | DepartmentName	 |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, depQues3.getId(), depQues3.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Khong ton tai phong nay tren he thong");
		}

	}

	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Kiem tra department co ton tai khong");
		System.out.println("Nhap department name: ");
		String name = ScannerUltis.inputString();
		Boolean check = depDAO.isDepartmentNameExists(name);
		if (check) {
			System.out.println(name.toUpperCase() + " da co tren he thong");
			question1();
		} else {
			System.out.println("Ten nay chua co tren he thong");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException {
		System.out.println("Tao department moi");
		String newDepName = getNewName();

		if (depDAO.createDep(newDepName)) {
			System.out.println("Them thanh cong!");
			question1();
		} else {
			System.out.println("Khong thanh cong");
		}

	}

	private String getNewName() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhap ten department moi: ");
			String newName = ScannerUltis.inputString();
			if (depDAO.isDepartmentNameExists(newName)) {
				System.out.println("Ten da ton tai");
			} else {
				return newName;
			}
		}
	}

	public void question6() throws ClassNotFoundException, SQLException {
		System.out.println("Cap nhat ten department");
		int id = getIdUpdate();
		System.out.println("Nhap vao ten moi: ");
		String newName = ScannerUltis.inputString();
		if (depDAO.updateDepartmentName(id, newName)) {
			System.out.println("Update thanh cong");
			question1();
		} else {
			System.out.println("Update khong thanh cong");
		}

	}

	private int getIdUpdate() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhap ID phong can update: ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = depDAO.getDepartmentById(id);
			if (dep == null) {
				System.out.println("Phong khong ton tai");
			} else {
				return id;
			}
		}
	}

	public void question7() throws ClassNotFoundException, SQLException {
		int id = getIdDel();
		if (depDAO.deleteDepById(id)) {
			System.out.println("Xoa thanh cong department co id la " + id);
			question1();
		} else {
			System.out.println("Xoa khong thanh cong");
		}
	}

	private int getIdDel() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhap ID phong can xoa: ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = depDAO.getDepartmentById(id);
			if (dep == null) {
				System.out.println("Phong khong ton tai");
			} else {
				return id;
			}
		}
	}

}
