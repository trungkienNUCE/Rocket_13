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
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException ;
	public List<User> getManagerInProjects(int projectID) throws ClassNotFoundException, SQLException ;
	public List<User> getManagerInProjects() throws ClassNotFoundException, SQLException;
}
