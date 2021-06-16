//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.User;
import com.vti.entity.User.Role;
import com.vti.ultis.jdbcUltis;

/**
 * This class is UserRepository
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 14, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 14, 2021
 */
public class UserRepository implements IUserRepository {
	private jdbcUltis jdbc;

	public UserRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public User isLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `user` WHERE email= ? AND `password` = ? ;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullName(resultSet.getNString(4));
			Role role = Role.valueOf(resultSet.getString(5).toUpperCase());
			user.setRole(role);
			return user;
		} else {
			return null;
		}

	}

	@Override
	public boolean isAdmin(User user) {
		if (user.getRole() == Role.ADMIN) {
			return true;
		}
		return false;

	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#getListAllUser()
	 */
	@Override
	public List<User> getListAllUser() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `user` ORDER BY id";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<User> listUser = new ArrayList<User>();

		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullName(resultSet.getNString(4));
			Role role = Role.valueOf(resultSet.getString(5).toUpperCase());
			user.setRole(role);

			listUser.add(user);
		}
		jdbc.disConnection();
		return listUser;
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#isIdUserExist(int)
	 */
	@Override
	public boolean isIdUserExist(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `user` WHERE id = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#getListUserById()
	 */
	@Override
	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `user` WHERE id = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullName(resultSet.getNString(4));
			Role role = Role.valueOf(resultSet.getString(5).toUpperCase());
			user.setRole(role);

			return user;

		} else {
			jdbc.disConnection();
			return null;
		}
	}

}
