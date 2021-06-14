//
package com.vti.backend.businesslayer;

import java.sql.SQLException;

/**
 * This class is chuc nang cua nhan vien
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public interface IEmployeeService {
//	doi mat khau
	public Boolean changePassword(String password, String email) throws ClassNotFoundException, SQLException;
}
