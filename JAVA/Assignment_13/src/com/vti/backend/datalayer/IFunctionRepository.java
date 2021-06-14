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
 * This class is chuc nang chung
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public interface IFunctionRepository {
//	chuc nang dang nhap
	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException;


//	nhap id project thi tra ra danh sach account trong project
	public List<Integer> getListIDAccByIdProject(int idProject)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

//	nhap id project thi tra ra danh sach account la manger trong project
	public List<Account> getListManagerByIdProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
//	public List<Account> getListAcc()
//			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

//	nhap id account thi tra ra cac project ma account lam viec
	public Account getListAccByIdAcc(int AccID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

//	nhap id project thi tra ra ten thong tin project do
	public Project getProjectByIdProject(int idProject) throws ClassNotFoundException, SQLException;

//	nhao id project kiem tra xem project do co tren HT khong
	public Boolean isIdProjectExists(int idProject) throws SQLException, ClassNotFoundException;
}
