//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.ManageProject;
import com.vti.entity.Project;
import com.vti.ultis.jdbcUltis;

/**
 * This class is AdminRepository
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class AdminRepository implements IAdminRepository, IFunctionRepository {
	private jdbcUltis jdbc;

	public AdminRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	/*
	 * @see
	 * com.vti.backend.datalayer.IAdminRepository#isEmailExists(java.lang.String)
	 */
	@Override
//	Kiem tra xem email nhap vao da ton tai chua
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `Account` WHERE (Email = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
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
	 * @see
	 * com.vti.backend.datalayer.IAdminRepository#createAcc(com.vti.entity.Account)
	 */
	@Override
	public Boolean createAcc(Account acc) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO `Account` (FullName, Email, ExpInYear, ProSkill) VALUE ( ?, ?, ?, ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);

		preStatement.setString(1, acc.getFullName());
		preStatement.setString(2, acc.getEmail());
		preStatement.setInt(3, acc.getExpInYear());
		preStatement.setString(4, acc.getProSkill());
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/*
	 * @see
	 * com.vti.backend.datalayer.IAdminRepository#createAcc1(com.vti.entity.Account)
	 */
	@Override
	public Boolean createAcc1(Account acc) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO `Account` (FullName, Email, ExpInYear, ProSkill) VALUE ( ?, ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);

		preStatement.setString(1, acc.getFullName());
		preStatement.setString(2, acc.getEmail());
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IAdminRepository#isIdProjectExists(int)
	 */
	@Override
	public Boolean isIdProjectExists(int idProject) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Project WHERE ProjectID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, idProject);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			return false;

		}
	}

	/*
	 * @see com.vti.backend.datalayer.IAdminRepository#createProject(com.vti.entity.
	 * Project)
	 */
	@Override
	public Boolean createProject(Project project) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Project (ProjectName, TeamSize) VALUE	(?, ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, project.getName());
		preStatement.setInt(2, project.getTeamSize());
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IFunctionRepository#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Admin` WHERE UserName = ? AND `PassWord` = ?";
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
		String sql = "SELECT * FROM ManagerProject WHERE ProjectID = ? ";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, idProject);
		ResultSet resultSet = preStatement.executeQuery();

		List<Integer> listManageProject = new ArrayList<>();

		while (resultSet.next()) {
//			ManageProject mp = new ManageProject();
			int[] arr = new int[listManageProject.size()];

//			mp.setProjectId(resultSet.getInt(1));
//			mp.setAccountId(resultSet.getInt(2));

//			listManageProject.add(mp);

		}
		jdbc.disConnection();
		return listManageProject;
	}

	/*
	 * @see
	 * com.vti.backend.datalayer.IFunctionRepository#getListManagerByIdProject()
	 */
	@Override
	public List<Account> getListManagerByIdProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.backend.datalayer.IFunctionRepository#getListProjectByIdAcc()
	 */
	@Override
	public List<Project> getListProjectByIdAcc()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.backend.datalayer.IFunctionRepository#getListProject()
	 */
	@Override
	public List<Project> getListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Project";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Project> listProject = new ArrayList<Project>();

		while (resultSet.next()) {
			Project project = new Project(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			listProject.add(project);
		}
		jdbc.disConnection();
		return listProject;
	}

	/*
	 * @see com.vti.backend.datalayer.IFunctionRepository#getProjectByIdProject(int)
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
		String sql = "SELECT * FROM `Account` WHERE AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, AccID);
		ResultSet resultSet = preStatement.executeQuery();

//		List<Account> listAcc = new ArrayList<Account>();

//		while (resultSet.next()) {
//			Account acc = new Account();
//			
//			acc.setId(resultSet.getInt(1));
//			acc.setFullName(resultSet.getString(2));
//			acc.setEmail(resultSet.getString(3));
//			acc.setPassWord(resultSet.getNString(4));
//			acc.setExpInYear(resultSet.getInt(5));
//			acc.setProSkill(resultSet.getNString(6));
//
//			listAcc.add(acc);
//		}
//		jdbc.disConnection();
//		return listAcc;
		if (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setFullName(resultSet.getString(2));
			acc.setEmail(resultSet.getString(3));
			acc.setPassWord(resultSet.getNString(4));
			acc.setExpInYear(resultSet.getInt(5));
			acc.setProSkill(resultSet.getNString(6));
			return acc;

		} else {
			jdbc.disConnection();
			return null;
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IAdminRepository#getListAccByEmail(java.lang.
	 * String)
	 */
	@Override
	public Account getListAccByEmail(String email)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM `account` WHERE Email = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setFullName(resultSet.getString(2));
			acc.setEmail(resultSet.getString(3));
			acc.setPassWord(resultSet.getNString(4));
			acc.setExpInYear(resultSet.getInt(5));
			acc.setProSkill(resultSet.getNString(6));
			return acc;

		} else {
			jdbc.disConnection();
			return null;
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IFunctionRepository#getListAcc()
	 */
	@Override
	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM `account` ORDER BY AccountID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Account> listAcc = new ArrayList<Account>();

		while (resultSet.next()) {
			Account acc = new Account(resultSet.getInt(1), resultSet.getNString(2), resultSet.getNString(3),
					resultSet.getNString(4), resultSet.getInt(5), resultSet.getNString(6));
			listAcc.add(acc);
		}
		jdbc.disConnection();
		return listAcc;
	}

	/*
	 * @see com.vti.backend.datalayer.IAdminRepository#addAccInProject(int, int)
	 */
	@Override
	public Boolean addAccInProject(int idProject, int idAccount)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "INSERT INTO ManagerProject VALUE (?,?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, idProject);
		preStatement.setInt(2, idAccount);
		int resultSet = preStatement.executeUpdate();

		List<ManageProject> listManagePro = new ArrayList<ManageProject>();

		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

}
