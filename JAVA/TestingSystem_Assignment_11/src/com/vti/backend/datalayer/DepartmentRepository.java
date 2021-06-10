//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entity.Department;
import com.vti.ultis.jdbcUltis;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 9, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 9, 2021
 */
public class DepartmentRepository implements IDepartmentService {
	private jdbcUltis jdbc;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department ORDER BY DepartmentID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Department> listDep = new ArrayList<Department>();

		while (resultSet.next()) {
//			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			Department dep = new Department(resultSet.getInt(1), resultSet.getString(2));
			listDep.add(dep);
		}
		jdbc.disConnection();
		return listDep;
	}

	public Department getDepById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE (DepartmentID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
//			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			Department dep = new Department(resultSet.getInt(1), resultSet.getString(2));
			return dep;
		} else {
			jdbc.disConnection();
			return null;
		}

	}

	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
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
		String sql = "INSERT INTO Department(DepartmentName) VALUES (?)";
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

	public Boolean updateDepartmentName(int id, String name) throws ClassNotFoundException, SQLException {
		Department depID = getDepById(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?)";
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

	public Boolean delDepById(int id) throws ClassNotFoundException, SQLException {
		Department depID = getDepById(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "DELETE FROM Department WHERE (DepartmentID = ?)";
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
