//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
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
public class UserService implements IUserService{

	private IUserRepository userRepository;

	public UserService() throws FileNotFoundException, IOException {
		userRepository = new UserRepository();
	}

	@Override
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		
		return userRepository.isLogin(email, password);
	}

	@Override
	public List<User> getManagerInProjects(int projectID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getManagerInProjects(projectID);
	}

	@Override
	public List<User> getManagerInProjects() throws ClassNotFoundException, SQLException {
		
		return userRepository.getManagerInProjects();
	}
	

}
