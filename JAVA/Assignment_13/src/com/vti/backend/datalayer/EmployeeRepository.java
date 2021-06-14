//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IFunctionService;
import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;
import com.vti.ultis.jdbcUltis;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class EmployeeRepository implements IFunctionRepository, IEmployeeRepository{
	private jdbcUltis jdbc;

	public EmployeeRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	/* 
	* @see com.vti.backend.datalayer.IFunctionRepository#login(java.lang.String, java.lang.String)
	*/
	@Override
	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Account` WHERE Email = ? AND `PassWord` = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/* 
	* @see com.vti.backend.datalayer.IFunctionRepository#getListAccByIdProject()
	*/
	@Override
	public List<Integer> getListIDAccByIdProject(int idProject)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	* @see com.vti.backend.datalayer.IFunctionRepository#getListManagerByIdProject()
	*/
	@Override
	public List<Account> getListManagerByIdProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


	/* 
	* @see com.vti.backend.businesslayer.IFunctionService#isIdProjectExists(int)
	*/
	@Override
	public Boolean isIdProjectExists(int idProject) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	/* 
	* @see com.vti.backend.businesslayer.IFunctionService#getProjectByIdProject(int)
	*/
	@Override
	public Project getProjectByIdProject(int idProject) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	/* 
	* @see com.vti.backend.datalayer.IFunctionRepository#getListAccByIdAcc(int)
	*/
	@Override
	public Account getListAccByIdAcc(int AccID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	/* 
	* @see com.vti.backend.datalayer.IEmployeeRepository#changePassword(java.lang.String, java.lang.String)
	*/
	@Override
	public Boolean changePassword(String password, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
