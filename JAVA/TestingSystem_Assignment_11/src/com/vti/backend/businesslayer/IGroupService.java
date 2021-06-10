//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Group;

/**
 * This class is used manage method of GroupService 
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public interface IGroupService {
	public List<Group> getListGroup() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	public Group getGroupById(int id) throws ClassNotFoundException, SQLException;

	public Boolean isGroupExists(String name) throws ClassNotFoundException, SQLException;

	public Boolean createGroup(String name) throws ClassNotFoundException, SQLException;

	public Boolean updateGroup(int id, String newName) throws ClassNotFoundException, SQLException;

	public Boolean delGroupById(int id) throws ClassNotFoundException, SQLException;
}
