//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;

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
public interface IAdminRepository {
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException;

//	them moi quan ly
	public Boolean createAcc(Account acc) throws SQLException, ClassNotFoundException;

//	them moi nhan vien
	public Boolean createAcc1(Account acc) throws SQLException, ClassNotFoundException;

	public Boolean isIdProjectExists(int idProject) throws SQLException, ClassNotFoundException;

//	them du an moi
	public Boolean createProject(Project project) throws SQLException, ClassNotFoundException;

//	tim nhan vien qua dia chi email
	public Account getListAccByEmail(String email)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public Boolean addAccInProject(int idProject, int idAccount)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

//	nhap id account thi tra ra cac project ma account lam viec
	public List<Project> getListProjectByIdAcc()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

//	lay ra tat ca cac project
	public List<Project> getListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<Account> getListAcc()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
}
