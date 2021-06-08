package com.vti.backend;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;
import com.vti.DAO.DepartmentDAO;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class Exercise3 {
	private jdbcUltis jdbc;
	private DepartmentDAO depDAO;

	public void deleteDepartmentUsingProcedure(int id) throws Exception {
		jdbc = new jdbcUltis();
		depDAO = new DepartmentDAO();
		if (!depDAO.isDepartmentIdExists(id)) {
			System.out.println("Khong ton tai");
			jdbc.disConnection();
		} else {
			String sql = "{CALL sp_delete_department(?)}";
			PreparedStatement callabeStatement = jdbc.createPrepareStatement(sql);

			callabeStatement.setInt(1, id);

			callabeStatement.executeUpdate();

			jdbc.disConnection();
		}

	}

	public void question1() throws Exception {
		System.out.println("Nhap id can xoa: ");
		int id = ScannerUltis.inputIntPositive();

		new Exercise3().deleteDepartmentUsingProcedure(id);
		System.out.println("Xoa thanh cong!");

	}
}
