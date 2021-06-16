//
package com.vti.backend.businesslayer;

import java.sql.SQLException;

import com.vti.entity.User;

/**
 * This class is IAdminService
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 15, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 15, 2021
 */
public interface IAdminService {

	public boolean createAccount(User user) throws SQLException, ClassNotFoundException;

	public boolean delUserById(int id) throws ClassNotFoundException, SQLException;
}
