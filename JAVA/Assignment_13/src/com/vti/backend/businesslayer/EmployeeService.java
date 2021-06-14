//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AdminRepository;
import com.vti.backend.datalayer.EmployeeRepository;
import com.vti.backend.datalayer.IFunctionRepository;
import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;

/**
 * This class is EmployeeService
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class EmployeeService implements IFunctionService, IEmployeeService {
	private IFunctionRepository employeeRepository;

	public EmployeeService() throws FileNotFoundException, IOException {
		employeeRepository = new EmployeeRepository();
	}

	/*
	 * @see com.vti.backend.businesslayer.IFunctionService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return employeeRepository.login(email, password);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IFunctionService#getListAccByIdProject(int)
	 */
	@Override
	public List<Integer> getListIDAccByIdProject(int idProject)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IFunctionService#getListManagerByIdProject()
	 */
	@Override
	public List<Account> getListManagerByIdProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IFunctionService#getProjectByIdProject(int)
	 */
	@Override
	public Project getProjectByIdProject(int idProject) throws ClassNotFoundException, SQLException {
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
	 * @see com.vti.backend.businesslayer.IFunctionService#getListAccByIdAcc(int)
	 */
	@Override
	public Account getListAccByIdAcc(int AccID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	* @see com.vti.backend.businesslayer.IEmployeeService#changePassword(java.lang.String, java.lang.String)
	*/
	@Override
	public Boolean changePassword(String password, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
