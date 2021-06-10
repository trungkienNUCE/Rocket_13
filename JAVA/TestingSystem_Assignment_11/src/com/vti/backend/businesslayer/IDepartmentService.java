//
package com.vti.backend.businesslayer;

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
public interface IDepartmentService {

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException;

	public Department getDepById(int id) throws ClassNotFoundException, SQLException;

	public Boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException;

	public Boolean createDep(String name) throws ClassNotFoundException, SQLException;

	public Boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException;

	public Boolean delDepById(int id) throws ClassNotFoundException, SQLException;
}
