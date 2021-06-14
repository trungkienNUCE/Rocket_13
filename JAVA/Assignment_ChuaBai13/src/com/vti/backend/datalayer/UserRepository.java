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
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `user` WHERE email= ? AND `password` = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<User> getManagerInProjects(int projectID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT 	u.id, u.email, u.`fullName`\r\n" + "FROM	`ProjectAndUser` pau\r\n"
				+ "INNER JOIN	`User` u	ON u.id = pau.userId\r\n" + "WHERE	pau.projectId = ?;";
		List<User> listUser = new ArrayList<User>();
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, projectID);
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
	public List<User> getManagerInProjects() throws ClassNotFoundException, SQLException {
		String sql = "SELECT 	u.id, u.email, u.`fullName`\r\n" + "FROM	`ProjectAndUser` pau\r\n"
				+ "JOIN	`User` u	ON u.id = pau.userId\r\n" + "WHERE	`Role` = 'MANAGER';";
		List<User> listManager = new ArrayList<User>();
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullName(resultSet.getString(3));
			listManager.add(user);
		}
		return listManager;

	}

}
