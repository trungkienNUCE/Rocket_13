package com.vit.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.jdbcUltis;

public class DepartmentDAO {
	private jdbcUltis jdbc;

	public DepartmentDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		String sql = "Select * from Department order by DepartmentID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Department> listDep = new ArrayList<Department>();

		while (resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			listDep.add(dep);
		}
		jdbc.disConnection();
		return listDep;
	}

	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException {
		String sql = "Select * from Department where DepartmentID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			return dep;
		} else {
			jdbc.disConnection();
			return null;
		}

	}

	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		String sql = "Select * from Department WHERE DepartmentName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, name);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			return false;

		}
	}

	public Boolean createDep(String name) throws ClassNotFoundException, SQLException {
		String sql = "Insert into Department(DepartmentName) values (?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, name);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}
//	public Boolean isDepartmentIdExists(int id) throws ClassNotFoundException, SQLException {
//		String sql = "Select * from Department WHERE DepartmentID = ?";
//		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
//		preStatement.setInt(1, id);
//		ResultSet resultSet = preStatement.executeQuery();
//		if (resultSet.next()) {
//			jdbc.disConnection();
//			return true;
//		} else {
//			return false;
//
//		}
//	}

	public boolean updateDepartmentName(int id, String name) throws ClassNotFoundException, SQLException {
		Department depID = getDepartmentById(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "Update Department SET DepartmentName = ? WHERE (DepartmentID = ?)";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setString(1, name);
			preStatement.setInt(2, id);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}

	}

	public boolean deleteDepById(int id) throws ClassNotFoundException, SQLException {
		Department depID = getDepartmentById(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "Delete from Department WHERE (DepartmentID = ?)";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setInt(1, id);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}

	}

}
