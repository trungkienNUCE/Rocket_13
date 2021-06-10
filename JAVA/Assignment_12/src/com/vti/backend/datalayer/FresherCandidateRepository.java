//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.FresherCandidate;
import com.vti.ultis.jdbcUltis;

/**
 * This class is FresherCandidateRepository
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class FresherCandidateRepository implements IFresherCandidateRepository {
	private jdbcUltis jdbc;

	public FresherCandidateRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	/*
	 * @see
	 * com.vti.backend.datalayer.IFresherCandidateRepository#insertFresherCandidate(
	 * java.lang.String, java.lang.String, int, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Boolean insertFresherCandidate(String userName, String fullName, String phone, String email, String password,
			String GraduationRank) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO FresherCandidate(UserName, FullName	, Phone	, Email	, `PassWord`, GraduationRank)"
				+ "VALUES (?, ?	,?, ?,?, ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, userName);
		preStatement.setString(2, fullName);
		preStatement.setString(3, phone);
		preStatement.setString(4, email);
		preStatement.setString(5, password);
		preStatement.setString(6, GraduationRank);

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
	 * @see
	 * com.vti.backend.datalayer.IFresherCandidateRepository#updateFresherCandidate(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateFresherCandidate(String password, String email) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE freshercandidate SET PassWord = ? WHERE (Email = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, password);
		preStatement.setString(2, email);
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
	 * @see
	 * com.vti.backend.datalayer.IFresherCandidateRepository#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM freshercandidate WHERE UserName = ? AND `PassWord` = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, userName);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

}
