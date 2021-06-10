//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
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
public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
	}

	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
//		to do logic
		return accountService.getListAcc();

	}

	public Account getAccountByID(int id) {
		try {
			return accountService.getAccountByID(id);
		} catch (Exception e) {
			return null;
		}

	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#isAccNameExists(java.lang.
	 * String)
	 */
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		try {
			return accountService.isAccNameExists(name);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#createAcc(com.vti.entity.
	 * Account, int, int)
	 */
	public Boolean createAcc(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		try {
			return accountService.createAcc(acc, depId, posId);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#delAccById(int)
	 */
	public Boolean delAccById(int id) throws ClassNotFoundException, SQLException {
		try {
			return accountService.delAccById(id);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByEmail(int,
	 * java.lang.String)
	 */
	public Boolean updateByEmail(int id, String newEmail) throws ClassNotFoundException, SQLException {
		try {
			return accountService.updateByEmail(id, newEmail);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByUserName(int,
	 * java.lang.String)
	 */
	public Boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {
		try {
			return accountService.updateByUserName(id, newUserName);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByFullName(int,
	 * java.lang.String)
	 */
	public Boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		try {
			return accountService.updateByFullName(id, newFullName);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByDepId(int, int)
	 */
	public Boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException {
		try {
			return accountService.updateByDepId(id, idDep);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IAccountService#updateByPosId(int, int)
	 */
	public Boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {
		try {
			return accountService.updateByPosId(id, idPos);
		} catch (Exception e) {
			return null;
		}
	}

}
