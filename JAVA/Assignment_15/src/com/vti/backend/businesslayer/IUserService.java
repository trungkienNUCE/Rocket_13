//
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

/**
 * This class is IUserService
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 14, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 14, 2021
 */
public interface IUserService {
	public User isLogin(String email, String password) throws SQLException, ClassNotFoundException;

	public boolean isAdmin(User user);

	public List<User> getListAllUser() throws SQLException, ClassNotFoundException;

//	khi nhap id de tim user, se kiem tra ID do co ton tai khong?
	public boolean isIdUserExist(int id) throws ClassNotFoundException, SQLException;

	public User getUserById(int id) throws SQLException, ClassNotFoundException;

}
