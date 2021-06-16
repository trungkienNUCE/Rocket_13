//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

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
public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}

	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {

		return userService.isLogin(email, password);
	}

	public List<User> getManagerInProjects(String projectName) throws SQLException, ClassNotFoundException {

		return userService.getManagerInProjects(projectName);

	}

	public boolean isAdmin(User user) {
		return userService.isAdmin(user);
	};

	public boolean createAccount(User user) throws SQLException, ClassNotFoundException {
		return userService.createAccount(user);
	};

}
