//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
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
public class AccountRepository implements IAccountService {
	private jdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account ORDER BY AccountID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Account> listAcc = new ArrayList<Account>();

		while (resultSet.next()) {
			Account acc = new Account();

			acc.setAccountId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUserName(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentRepository depRep = new DepartmentRepository();
			Department dep = depRep.getDepById(resultSet.getInt(5));
			acc.setDepartment(dep);

			PositionRepository posRep = new PositionRepository();
			Position pos = posRep.getPosById(resultSet.getInt(6));
			acc.setPosition(pos);

			Date createDate = resultSet.getDate(7);
			acc.setCreateDate(createDate);

			listAcc.add(acc);
		}
		jdbc.disConnection();
		return listAcc;
	}

	public Account getAccountByID(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM account WHERE AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Account acc = new Account();
			acc.setAccountId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUserName(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentRepository depRep = new DepartmentRepository();
			Department dep = depRep.getDepById(resultSet.getInt(5));
			acc.setDepartment(dep);

			PositionRepository posRep = new PositionRepository();
			Position pos = posRep.getPosById(resultSet.getInt(6));
			acc.setPosition(pos);

			Date createDate = resultSet.getDate(7);
			acc.setCreateDate(createDate);

			return acc;

		} else {
			jdbc.disConnection();
			return null;
		}

	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#isAccNameExists(java.lang.
	 * String)
	 */
	@Override
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `Account` WHERE (FullName = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, name);
		ResultSet resultSet = preStatement.executeQuery();

		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}

	}

//	/*
//	 * @see com.vti.backend.businesslayer.IAccountService#isAccIdExists(int)
//	 */
//	@Override
//	public Boolean isAccIdExists(int id) throws SQLException, ClassNotFoundException {
//		String sql = "SELECT * FROM `Account` WHERE AccountID = ?";
//		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
//		preStatement.setInt(1, id);
//		ResultSet resultSet = preStatement.executeQuery();
//
//		if (resultSet.next()) {
//			jdbc.disConnection();
//			return true;
//		} else {
//			jdbc.disConnection();
//			return null;
//		}
//	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#createAcc(com.vti.entity.
	 * Account, int, int)
	 */
	@Override
	public Boolean createAcc(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)"
				+ "VALUES 				(?, ?, ?, ?, ?, now())";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, acc.getEmail());
		preStatement.setNString(2, acc.getUserName());
		preStatement.setNString(3, acc.getFullName());
		preStatement.setInt(4, depId);
		preStatement.setInt(5, posId);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#delAccById(int)
	 */
	@Override
	public Boolean delAccById(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE  FROM `Account` WHERE (AccountID = ?)";
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

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByEmail(int,
	 * java.lang.String)
	 */
	@Override
	public Boolean updateByEmail(int id, String newEmail) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `account` SET Email = ? WHERE (AccountID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newEmail);
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

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByUserName(int,
	 * java.lang.String)
	 */
	@Override
	public Boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `account` SET UserName = ? WHERE (AccountID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newUserName);
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

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByFullName(int,
	 * java.lang.String)
	 */
	@Override
	public Boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `account` SET FullName = ? WHERE (AccountID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newFullName);
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

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByDepId(int, int)
	 */
	@Override
	public Boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `account` SET DepartmentID = ? WHERE (AccountID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, idDep);
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

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByPosId(int, int)
	 */
	@Override
	public Boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `account` SET PositionID = ? WHERE (AccountID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, idPos);
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
