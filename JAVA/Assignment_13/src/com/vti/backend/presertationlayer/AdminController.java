//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AdminService;
import com.vti.backend.businesslayer.IAdminService;
import com.vti.backend.businesslayer.IFunctionService;
import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;

/**
 * This class is admin controller
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class AdminController {
	private IAdminService adminService;
	private IFunctionService functionService;

	public AdminController() throws FileNotFoundException, IOException {
		adminService = new AdminService();
		functionService = new AdminService();
	}

	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		return functionService.login(email, password);

	}

	public List<Integer> getListAccByIdProject(int idProject)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return functionService.getListIDAccByIdProject(idProject);

	}

	public List<Project> getListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return adminService.getListProject();
	}

	public Account getListAccByEmail(String email)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return adminService.getListAccByEmail(email);
	}

	public Boolean isIdProjectExists(int idProject) throws SQLException, ClassNotFoundException {
		return functionService.isIdProjectExists(idProject);
	}

	public Account getListAccByIdAcc(int AccID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return functionService.getListAccByIdAcc(AccID);
	}

	public Boolean createProject(Project project) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminService.createProject(project);
	}

	public Boolean createAcc(Account acc) throws SQLException, ClassNotFoundException {
		return adminService.createAcc(acc);
	}

	public Boolean createAcc1(Account acc) throws SQLException, ClassNotFoundException {
		return adminService.createAcc(acc);
	}

	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return adminService.getListAcc();
	}
	public Boolean addAccInProject(int idProject, int idAccount)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		return adminService.addAccInProject(idProject, idAccount);
	}

	
}
