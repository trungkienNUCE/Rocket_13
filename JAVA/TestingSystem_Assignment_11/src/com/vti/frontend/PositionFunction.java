//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presertationlayer.DepartmentController;
import com.vti.backend.presertationlayer.PositionController;
import com.vti.entity.Department;
import com.vti.entity.Position;
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
public class PositionFunction {
	private jdbcUltis jdbc;
	Scanner sc = new Scanner(System.in);

	public static void getListPosition()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		PositionController posController = new PositionController();
		List<Position> listPos = posController.getListPosition();

		System.out.println("Thong tin cac Position la: ");

		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("| ID     | PositionName	 	  |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Position pos : listPos) {
			System.out.format(leftAlignFormat, pos.getPositionId(), pos.getPositionName());
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
		PositionController posController = new PositionController();

		System.out.println("Tim kiem theo ID. Nhap ID: ");
		int id1 = ScannerUltis.inputIntPositive();
		Position pos = posController.getPosById(id1);
		System.out.println("Thong tin cac Position co id " + id1 + " la: ");

		if (pos != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID     | PositiontName	 |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, pos.getPositionId(), pos.getPositionName());
			System.out.format("+--------+-----------------------+%n");

		} else {
			System.out.println("Khong ton tai");
		}
	}


}
