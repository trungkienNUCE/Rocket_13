//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 9, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 9, 2021
 */
public interface IAccountService {
	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	public Account getAccountByID(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException;

	public Boolean createAcc(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException;

	public Boolean delAccById(int id) throws ClassNotFoundException, SQLException;

	public Boolean updateByEmail(int id, String newEmail) throws ClassNotFoundException, SQLException;

	public Boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException;

	public Boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException;

	public Boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException;

	public Boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException;

}
