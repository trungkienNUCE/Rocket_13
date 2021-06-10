//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entity.Department;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class DepartmentController{
	private IDepartmentService depService;

	public DepartmentController() throws FileNotFoundException, IOException {
		depService = new DepartmentService();
	}

	/*
	 * @see com.vti.backend.businesslayer.IDepartmentService#getListDepartment()
	 */
	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return depService.getListDepartment();
	}

	/*
	 * @see com.vti.backend.businesslayer.IDepartmentService#getDepById(int)
	 */
	public Department getDepById(int id) throws ClassNotFoundException, SQLException {
		return depService.getDepById(id);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IDepartmentService#isDepartmentNameExists(java.
	 * lang.String)
	 */
	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return depService.isDepartmentNameExists(name);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IDepartmentService#createDep(java.lang.String)
	 */
	public Boolean createDep(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return depService.createDep(name);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IDepartmentService#updateDepartmentName(int,
	 * java.lang.String)
	 */
	public Boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return depService.updateDepartmentName(id, newName);
	}

	/*
	 * @see com.vti.backend.businesslayer.IDepartmentService#delDepById(int)
	 */
	public Boolean delDepById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return depService.delDepById(id);
	}
}
