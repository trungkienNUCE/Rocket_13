//
package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

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
public interface IUserRepository {
	public User isLogin(String email, String password) throws SQLException, ClassNotFoundException;

	public boolean isAdmin(User user);

	public List<User> getMemberInProjects(String projectName) throws SQLException, ClassNotFoundException;

	public boolean createAccount(User user) throws SQLException, ClassNotFoundException;

}
