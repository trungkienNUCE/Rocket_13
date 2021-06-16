//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IAdminRepository;
import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

/**
 * This class is UserService
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 14, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 14, 2021
 */
public class UserService implements IUserService {

	private IUserRepository userRepository;

	public UserService() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
	}

	@Override
	public User isLogin(String email, String password) throws ClassNotFoundException, SQLException {

		return userRepository.isLogin(email, password);
	}

	@Override
	public boolean isAdmin(User user) {
		// TODO Auto-generated method stub
		return userRepository.isAdmin(user);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#getListAllUser()
	 */
	@Override
	public List<User> getListAllUser() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getListAllUser();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#isIdUserExist(int)
	 */
	@Override
	public boolean isIdUserExist(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isIdUserExist(id);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#getListUserById()
	 */
	@Override
	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

}
