//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.GroupRepository;
import com.vti.entity.Account;
import com.vti.entity.Group;

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
public class AccountService implements IAccountService{
	private AccountRepository accRepository;

	public AccountService() throws FileNotFoundException, IOException {
		accRepository = new AccountRepository();
	}
	@Override
	public List<Account> getListAcc() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		return accRepository.getListAcc();
		
	}

	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TrungKienTran
	 * @create_date: Jun 10, 2021
	 * @version: 1.0
	 * @modifer: TrungKienTran
	 * @modifer_date: Jun 10, 2021
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public Account getAccountByID(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accRepository.getAccountByID(id);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#isAccNameExists(java.lang.String)
	*/
	@Override
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		return accRepository.isAccNameExists(name);
	}


	/* 
	* @see com.vti.backend.businesslayer.IAccountService#createAcc(com.vti.entity.Account, int, int)
	*/
	@Override
	public Boolean createAcc(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		return accRepository.createAcc(acc, depId, posId);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#delAccById(int)
	*/
	@Override
	public Boolean delAccById(int id) throws ClassNotFoundException, SQLException {
		return accRepository.delAccById(id);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#updateByEmail(int, java.lang.String)
	*/
	@Override
	public Boolean updateByEmail(int id, String newEmail) throws ClassNotFoundException, SQLException {
		return accRepository.updateByEmail(id, newEmail);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#updateByUserName(int, java.lang.String)
	*/
	@Override
	public Boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {
		return accRepository.updateByUserName(id, newUserName);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#updateByFullName(int, java.lang.String)
	*/
	@Override
	public Boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		return accRepository.updateByFullName(id, newFullName);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#updateByDepId(int, int)
	*/
	@Override
	public Boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException {
		return accRepository.updateByDepId(id, idDep);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#updateByPosId(int, int)
	*/
	@Override
	public Boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {
		return accRepository.updateByPosId(id, idPos);
	}
	
	
}
