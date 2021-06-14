//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AdminRepository;
import com.vti.backend.datalayer.IAdminRepository;
import com.vti.backend.datalayer.IFunctionRepository;
import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;

/**
 * This class is AdminService
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class AdminService implements IAdminService, IFunctionService {
	private IAdminRepository adminRepository;
	private IFunctionRepository funtionRepository;

	public AdminService() throws FileNotFoundException, IOException {
		funtionRepository = new AdminRepository();
		adminRepository = new AdminRepository();
	}

	/*
	 * @see com.vti.backend.businesslayer.IFunctionService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return funtionRepository.login(email, password);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IFunctionService#getListAccByIdProject(int)
	 */
	@Override
	public List<Integer> getListIDAccByIdProject(int idProject)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return funtionRepository.getListIDAccByIdProject(idProject);
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
	 * @see com.vti.backend.businesslayer.IFunctionService#getListProjectByIdAcc()
	 */
	@Override
	public List<Project> getListProjectByIdAcc()
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
	 * @see
	 * com.vti.backend.businesslayer.IAdminService#isEmailExists(java.lang.String)
	 */
	@Override
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IAdminService#createAcc(com.vti.entity.Account)
	 */
	@Override
	public Boolean createAcc(Account acc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.createAcc(acc);
	}

	/*
	 * @see com.vti.backend.businesslayer.IAdminService#createAcc1(com.vti.entity.
	 * Account)
	 */
	@Override
	public Boolean createAcc1(Account acc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.createAcc1(acc);
	}

	/*
	 * @see com.vti.backend.businesslayer.IAdminService#isIdProjectExists(int)
	 */
	@Override
	public Boolean isIdProjectExists(int idProject) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return funtionRepository.isIdProjectExists(idProject);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IAdminService#createProject(com.vti.entity.
	 * Project)
	 */
	@Override
	public Boolean createProject(Project project) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.createProject(project);
	}

	/*
	 * @see com.vti.backend.businesslayer.IFunctionService#getListAccByIdAcc(int)
	 */
	@Override
	public Account getListAccByIdAcc(int AccID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return funtionRepository.getListAccByIdAcc(AccID);
	}

	/*
	 * @see com.vti.backend.businesslayer.IAdminService#getListAccByEmail(java.lang.
	 * String)
	 */
	@Override
	public Account getListAccByEmail(String email)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return adminRepository.getListAccByEmail(email);
	}

	/*
	 * @see com.vti.backend.businesslayer.IAdminService#getListProject()
	 */
	@Override
	public List<Project> getListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return adminRepository.getListProject();
	}

	/*
	 * @see com.vti.backend.businesslayer.IAdminService#getListAcc()
	 */
	@Override
	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return adminRepository.getListAcc();
	}

	/*
	 * @see com.vti.backend.businesslayer.IAdminService#addAccInProject(int, int)
	 */
	@Override
	public Boolean addAccInProject(int idProject, int idAccount)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return adminRepository.addAccInProject(idProject, idAccount);
	}

}
