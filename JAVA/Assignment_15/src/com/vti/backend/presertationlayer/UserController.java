//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AdminService;
import com.vti.backend.businesslayer.IAdminService;
import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

/**
 * This class is user controller
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
	private IAdminService adminService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
		adminService = new AdminService();
	}

	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {

		return userService.isLogin(email, password);
	}

	public boolean isAdmin(User user) {
		return userService.isAdmin(user);
	};

	public List<User> getListAllUser() throws SQLException, ClassNotFoundException {
		return userService.getListAllUser();
	}

	public boolean isIdUserExist(int id) throws ClassNotFoundException, SQLException {
		return userService.isIdUserExist(id);
	}

	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		return userService.getUserById(id);
	}

//	cac chuc nang cua admin
	public boolean createAccount(User user) throws SQLException, ClassNotFoundException {
		return adminService.createAccount(user);
	};

	public boolean delUserById(int id) throws ClassNotFoundException, SQLException {
		return adminService.delUserById(id);
	}

}
