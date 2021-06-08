package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class AccountDAO {
	private jdbcUltis jdbc;

	public AccountDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "Select * from Account order by AccountID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Account> listAcc = new ArrayList<Account>();

		while (resultSet.next()) {
			Account acc = new Account();

			acc.setAccountId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUserName(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentDAO depDAO = new DepartmentDAO();
			Department dep = depDAO.getDepartmentById(resultSet.getInt(5));
			acc.setDep(dep);

			PositionDAO posDAO = new PositionDAO();
			Position pos = posDAO.getPositionById(resultSet.getInt(6));
			acc.setPos(pos);

			Date createDate = resultSet.getDate(7);
			acc.setCreateDate(createDate);

			listAcc.add(acc);

		}
		jdbc.disConnection();
		return listAcc;
	}

	public Account getAccounttById(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "Select * from Account where AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();

		if (resultSet.next()) {
			Account acc = new Account();

			acc.setAccountId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUserName(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentDAO depDAO = new DepartmentDAO();
			Department dep = depDAO.getDepartmentById(resultSet.getInt(5));
			acc.setDep(dep);

			PositionDAO posDAO = new PositionDAO();
			Position pos = posDAO.getPositionById(resultSet.getInt(6));
			acc.setPos(pos);

			Date createDate = resultSet.getDate(7);
			acc.setCreateDate(createDate);

			return acc;
		} else {
			jdbc.disConnection();
			return null;
		}

	}

	public Boolean isAccountExists(String name) throws ClassNotFoundException, SQLException {
		String sql = "Select * from Account WHERE FullName = ?";
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

	public Boolean createAcc(Account acc, int departmentId, int positionId)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)"
				+ "VALUES 				(?, ?, ?, ?, ?, now())";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, acc.getEmail());
		preStatement.setNString(2, acc.getUserName());
		preStatement.setNString(3, acc.getFullName());
		preStatement.setInt(4, departmentId);
		preStatement.setInt(5, positionId);
//		preStatement.setString(6, createDate);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean updateAccountName(int id, String name)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account accID = getAccounttById(id);
		if (accID == null) {
			return false;
		} else {
			String sql = "Update Account SET FullName = ? WHERE (AccountID = ?)";
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
	public boolean deleteDepById(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account accID = getAccounttById(id);
		if (accID == null) {
			return false;
		} else {
			String sql = "Delete from Account WHERE (AccountID = ?)";
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
