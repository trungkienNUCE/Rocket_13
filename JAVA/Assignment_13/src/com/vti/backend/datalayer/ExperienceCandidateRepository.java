////
//package com.vti.backend.datalayer;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.vti.entity.FresherCandidate;
//import com.vti.ultis.jdbcUltis;
//
///**
// * This class is ExperienceCandidateRepository
// * 
// * @Description: .
// * @author: TrungKienTran
// * @create_date: Jun 10, 2021
// * @version: 1.0
// * @modifer: TrungKienTran
// * @modifer_date: Jun 10, 2021
// */
//public class ExperienceCandidateRepository implements IExperienceCandidateRepository {
//	private jdbcUltis jdbc;
//
//	public ExperienceCandidateRepository() throws FileNotFoundException, IOException {
//		jdbc = new jdbcUltis();
//	}
//
//	/*
//	 * @see com.vti.backend.datalayer.IExperienceCandidateRepository#
//	 * insertExperienceCandidate(java.lang.String, java.lang.String, int,
//	 * java.lang.String, java.lang.String, int, java.lang.String)
//	 */
//	@Override
//	public Boolean insertExperienceCandidate(String userName, String fullName, String phone, String email,
//			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException {
//		String sql = "INSERT INTO ExperienceCandidate(UserName, FullName	, Phone	, Email	, `PassWord`, ExpInYear, ProSkill)"
//				+ "VALUES (?, ?	,?, ?,?, ?,?)";
//		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
//		preStatement.setString(1, userName);
//		preStatement.setString(2, fullName);
//		preStatement.setString(3, phone);
//		preStatement.setString(4, email);
//		preStatement.setString(5, password);
//		preStatement.setInt(6, expInYear);
//		preStatement.setString(7, proSkill);
//
//		int result = preStatement.executeUpdate();
//		if (result == 1) {
//			jdbc.disConnection();
//			return true;
//
//		} else {
//			jdbc.disConnection();
//			return false;
//		}
//
//	}
//
//	/*
//	 * @see com.vti.backend.datalayer.IExperienceCandidateRepository#
//	 * updateExperienceCandidate(java.lang.String, java.lang.String)
//	 */
//	@Override
//	public Boolean updateExperienceCandidate(String password, String email)
//			throws ClassNotFoundException, SQLException {
//		String sql = "UPDATE experiencecandidate SET PassWord = ? WHERE (Email = ?)";
//		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
//		preStatement.setString(1, password);
//		preStatement.setString(2, email);
//		int result = preStatement.executeUpdate();
//		if (result == 1) {
//			jdbc.disConnection();
//			return true;
//		} else {
//			jdbc.disConnection();
//			return false;
//		}
//	}
//
//	/*
//	 * @see
//	 * com.vti.backend.datalayer.IExperienceCandidateRepository#login(java.lang.
//	 * String, java.lang.String)
//	 */
//	@Override
//	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException {
//		String sql = "SELECT * FROM experiencecandidate WHERE UserName = ? AND `PassWord` = ?";
//		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
//		preStatement.setString(1, userName);
//		preStatement.setString(2, password);
//		ResultSet resultSet = preStatement.executeQuery();
//		if (resultSet.next()) {
//			jdbc.disConnection();
//			return true;
//		} else {
//			jdbc.disConnection();
//			return false;
//		}
//	}
//
//}
