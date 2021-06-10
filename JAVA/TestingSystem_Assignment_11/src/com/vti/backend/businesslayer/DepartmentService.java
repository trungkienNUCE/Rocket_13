//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
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
public class DepartmentService implements IDepartmentService {
	private DepartmentRepository depRepository;
	public DepartmentService() throws FileNotFoundException, IOException {
		depRepository = new DepartmentRepository();
	}
	/* 
	* @see com.vti.backend.businesslayer.IDepartmentService#getListDepartment()
	*/
	@Override
	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		return depRepository.getListDepartment();
	}

	/* 
	* @see com.vti.backend.businesslayer.IDepartmentService#getDepById(int)
	*/
	@Override
	public Department getDepById(int id) throws ClassNotFoundException, SQLException {
		return depRepository.getDepById(id);
	}

	/* 
	* @see com.vti.backend.businesslayer.IDepartmentService#isDepartmentNameExists(java.lang.String)
	*/
	@Override
	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		return depRepository.isDepartmentNameExists(name);
	}

	/* 
	* @see com.vti.backend.businesslayer.IDepartmentService#createDep(java.lang.String)
	*/
	@Override
	public Boolean createDep(String name) throws ClassNotFoundException, SQLException {
		return depRepository.createDep(name);
	}

	/* 
	* @see com.vti.backend.businesslayer.IDepartmentService#updateDepartmentName(int, java.lang.String)
	*/
	@Override
	public Boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		return depRepository.updateDepartmentName(id, newName);
	}

	/* 
	* @see com.vti.backend.businesslayer.IDepartmentService#delDepById(int)
	*/
	@Override
	public Boolean delDepById(int id) throws ClassNotFoundException, SQLException {
		return depRepository.delDepById(id);
	}

}
