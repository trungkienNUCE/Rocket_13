package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class Exercise1 {
	private jdbcUltis jdbc;

	public Exercise1() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println("Test ket noi");
		jdbc.connnectionTestting();
	}

	public void question2() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM testingsystem.position";
		ResultSet posResult = jdbc.executeQuery(sql);
		System.out.println("Thong tin cac Position la: ");

		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("| ID     | PositionName		 |%n");
		System.out.format("+--------+-----------------------+%n");

		while (posResult.next()) {
			System.out.format(leftAlignFormat, posResult.getInt(1), posResult.getString(2));
		}
		System.out.format("+--------+-----------------------+%n");
	}
//	public void questionAcc() throws ClassNotFoundException, SQLException {
//		String sql = "SELECT * FROM testingsystem.account";
//		ResultSet accResult = jdbc.executeQuery(sql);
//		System.out.println("Thong tin cac Account la: ");
//		
//		String leftAlignFormat = "| %-6d | %-21s | %-21s |%n";
//		System.out.format("+--------------------------------------------------------+%n");
//		System.out.format("| ID     | UserName		 | FullName		 |%n");
//		System.out.format("+--------+-----------------------+-----------------------+%n");
//		
//		while (accResult.next()) {
//			System.out.format(leftAlignFormat, accResult.getInt(1), accResult.getString(3), accResult.getString(4));
//		}
//		System.out.format("+--------+-----------------------+-----------------------+%n");
//	}

	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tao Position moi: ");
		String sql = "insert into Position (PositionName) values (?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		System.out.println("Chon Position 1. Dev, 2.Test, 3.Scrum Master, 4.PM ");
		String name = getName();
		preStatement.setString(1, name);
		if (preStatement.executeUpdate() == 1) {
			System.out.println("Tao thanh cong");
			question2();
		} else {
			System.out.println("Khong thanh cong");
		}
	}

	private String getName() {
		while (true) {
			switch (ScannerUltis.inputFunction(1, 4, "Nhap lai")) {
			case 1:
				return "Dev";
			case 2:
				return "Test";
			case 3:
				return "Scrum Master";
			case 4:
				return "PM";
			default:
				System.out.println("Nhap lai");
			}

		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Update Position: ");
		question2();
		System.out.println("Nhap ID can sua: ");
		int id = ScannerUltis.inputIntPositive();
		System.out.println("Chon Position 1. Dev, 2.Dev, 3.Scrum Master, 4.PM ");
		String newName = getName();

		String sql = "Update position Position set PositionName = ? WHERE PositionID = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newName);
		preStatement.setInt(2, id);
		if (preStatement.executeUpdate() == 1) {
			System.out.println("Update thanh cong");
			question2();
		} else {
			System.out.println("Khong thanh cong");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException {
		System.out.println("Xoa Posstion theo ID");
		question2();
		System.out.println("Nhap ID = ");
		int id = ScannerUltis.inputIntPositive();
		String sql = "DELETE FROM Position WHERE (PositionID = ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		if (preStatement.executeUpdate() == 1) {
			System.out.println("Da xoa thanh cong postion co id la " + id);
			question2();
		} else {
			System.out.println("Xoa khong thanh cong!");
		}

	}

}
