//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.GroupService;
import com.vti.entity.Department;
import com.vti.entity.Group;

/**
 * This class is GroupController 
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 9, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 9, 2021
 */
public class GroupController {
	private GroupService groupService;

	public GroupController() throws FileNotFoundException, IOException {
		groupService = new GroupService();
	}
	public List<Group> getListGroup() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
//		to do logic
		return groupService.getListGroup();
		
	}
	
	public Group getGroupById(int id) throws ClassNotFoundException, SQLException {
		return groupService.getGroupById(id);
	}
	public Boolean isGroupExists(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return groupService.isGroupExists(name);
	}

	public Boolean createGroup(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return groupService.createGroup(name);
	}
	public Boolean updateGroup(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return groupService.updateGroup(id, newName);
	}

	public Boolean delGroupById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return groupService.delGroupById(id);
	}
}
