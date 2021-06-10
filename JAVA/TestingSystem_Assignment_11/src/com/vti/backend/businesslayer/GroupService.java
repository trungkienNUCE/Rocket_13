//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.GroupRepository;
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
public class GroupService implements IGroupService{
	private GroupRepository repository;

	public GroupService() throws FileNotFoundException, IOException {
		repository = new GroupRepository();
	}
	
	@Override
	public List<Group> getListGroup() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return repository.getListGroup();
	}

	/* 
	* @see com.vti.backend.businesslayer.IGroupService#getGroupById(int)
	*/
	@Override
	public Group getGroupById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.getGroupById(id);
	}

	/* 
	* @see com.vti.backend.businesslayer.IGroupService#isGroupExists(java.lang.String)
	*/
	@Override
	public Boolean isGroupExists(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.isGroupExists(name);
	}

	/* 
	* @see com.vti.backend.businesslayer.IGroupService#createGroup(java.lang.String)
	*/
	@Override
	public Boolean createGroup(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.createGroup(name);
	}

	/* 
	* @see com.vti.backend.businesslayer.IGroupService#updateGroup(int, java.lang.String)
	*/
	@Override
	public Boolean updateGroup(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.updateGroup(id, newName);
	}

	/* 
	* @see com.vti.backend.businesslayer.IGroupService#delGroupById(int)
	*/
	@Override
	public Boolean delGroupById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.delGroupById(id);
	}
	
	
}
