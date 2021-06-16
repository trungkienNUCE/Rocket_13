//
package com.vti.backend.businesslayer;

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
public interface IUserService {
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException;

	public boolean isAdmin(User user);

	public List<User> getManagerInProjects(String projectName) throws SQLException, ClassNotFoundException;

	public boolean createAccount(User user) throws SQLException, ClassNotFoundException;

}
