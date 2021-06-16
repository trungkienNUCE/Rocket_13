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
 * This class is .
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

	@Override
	public List<User> getMemberInProjects(String projectName) throws SQLException, ClassNotFoundException {
		String sql = "SELECT 	u.id,u.email, u.`fullName`	\r\n" + "FROM	`ProjectAndUser` pau\r\n"
				+ "INNER JOIN	`User` u	ON u.id = pau.userId\r\n"
				+ "INNER JOIN  `project` p ON p.id = pau.projectId\r\n" + "WHERE	p.Project_Name = ?;  ";
		List<User> listUser = new ArrayList<User>();
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, projectName);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullName(resultSet.getString(3));
			listUser.add(user);
		}
		return listUser;

	}

	@Override
	public boolean createAccount(User user) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO `user` (`email`, `password`, `fullName`, `Role`) VALUES (?, '123456A',?, 'USER');\r\n"
				+ "";

		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, user.getEmail());
		preStatement.setNString(2, user.getFullName());
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
