//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.AdminService;
import com.vti.backend.businesslayer.EmployeeService;
import com.vti.backend.businesslayer.IAdminService;
import com.vti.backend.businesslayer.IEmployeeService;
import com.vti.backend.businesslayer.IFunctionService;

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
public class EmployeeController {
//	private IEmployeeService employeeService;
	private IFunctionService functionService;

	public EmployeeController() throws FileNotFoundException, IOException {
//		employeeService = new EmployeeService();
		functionService = new EmployeeService();
	}

	public Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		return functionService.login(email, password);

	}
}
