//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presertationlayer.DepartmentController;
import com.vti.backend.presertationlayer.GroupController;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.ultis.ScannerUltis;

/**
 * This class is used function of group
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 9, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 9, 2021
 */
public class GroupFunction {
	/**
	 * This method is get list all group
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
	public static void getListGroup() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();
		List<Group> listGroup = groupController.getListGroup();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Group Name	   	 |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Group group : listGroup) {
			System.out.format(leftAlignFormat, group.getId(), group.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	/**
	 * This method is get id group
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
	public static void getGroupById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();

		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int id1 = ScannerUltis.inputIntPositive();
		Group dep = groupController.getGroupById(id1);
		System.out.println("Thong tin cac Group co id " + id1 + " la: ");

		if (dep != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | Group Name	 	|%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, dep.getId(), dep.getName());
			System.out.format("+--------+-----------------------+%n");

		} else {
			System.out.println("Khong ton tai");
		}
	}

	/**
	 * This method is used check group is exists 
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
	public static void isGroupExists()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();

		System.out.println("Kiem tra group da co tren HT chua? Nhap ten group: ");
		String groupName = ScannerUltis.inputString();
		Boolean check = groupController.isGroupExists(groupName);

		if (check) {
			System.out.println("Group " + groupName.toUpperCase() + " da ton tai");
		} else {
			System.out.println("Group chua co tren he thong");
		}
	}

	/**
	 * This method is used create group
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
	public static void createGroup() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();

		String groupName = getGroupName();
		if (groupController.createGroup(groupName)) {
			System.out.println("Tao thanh cong");
			getListGroup();
		} else {
			System.out.println("Da co loi xay ra");
		}

	}

	/**
	 * This method is get new group name
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
	private static String getGroupName()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();
		while (true) {
			System.out.println("Nhap ten phong moi: ");
			String groupName = ScannerUltis.inputString();
			if (groupController.isGroupExists(groupName)) {
				System.out.println("Group da co tren he thong");
			} else {
				return groupName;
			}
		}
	}

	/**
	 * This method is used update group
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
	public static void updateGroup()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();
		System.out.println("Nhap ID Group can update: ");
		int groupId = getIdUpdate();
		System.out.println("Nhap vao ten group moi: ");
		String newName = ScannerUltis.inputString();
		if (groupController.updateGroup(groupId, newName)) {
			System.out.println("Update phong thanh cong");
		} else {
			System.out.println("Da co loi xay ra");
		}

	}

	/**
	 * This method is get id group to update/delete
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
	private static int getIdUpdate() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();
		while (true) {
			int id = ScannerUltis.inputIntPositive();
			Group group = groupController.getGroupById(id);
			if (group == null) {
				System.out.println("Khong co ID group tren HT");
			} else {
				return id;
			}

		}
	}

	/**
	 * This method is used delete group by ID
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
	public static void delGroupById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		GroupController groupController = new GroupController();
		System.out.println("Nhap Id Group can xoa: ");
		int groupId = getIdUpdate();
		if (groupController.delGroupById(groupId)) {
			System.out.println("Xoa group thanh cong");
		} else {
			System.out.println("Da co loi xay ra");
		}
	}
}
