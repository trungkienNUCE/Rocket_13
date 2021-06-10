//
package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.businesslayer.IGroupService;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.ultis.jdbcUltis;

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
public class GroupRepository implements IGroupService {
	private jdbcUltis jdbc;

	public GroupRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Group> getListGroup() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM `Group` ORDER BY GroupID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Group> listGroup = new ArrayList<Group>();

		while (resultSet.next()) {
			Group groups = new Group();

			groups.setId(resultSet.getInt(1));
			groups.setName(resultSet.getString(2));
			listGroup.add(groups);

		}
		jdbc.disConnection();
		return listGroup;
	}

	/*
	 * @see com.vti.backend.businesslayer.IGroupService#getGroupById(int)
	 */
	@Override
	public Group getGroupById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Group` WHERE (GroupID = ?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Group group = new Group(resultSet.getInt(1), resultSet.getNString(2));
			return group;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IGroupService#isGroupExists(java.lang.String)
	 */
	@Override
	public Boolean isGroupExists(String name) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Group` WHERE GroupName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, name);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			return false;

		}
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IGroupService#createGroup(java.lang.String)
	 */
	@Override
	public Boolean createGroup(String name) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `Group`(GroupName) VALUES (?)";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, name);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IGroupService#updateGroup(int,
	 * java.lang.String)
	 */
	@Override
	public Boolean updateGroup(int id, String newName) throws ClassNotFoundException, SQLException {
		Group groupId = getGroupById(id);
		if (groupId == null) {
			return false;
		} else {
			String sql = "UPDATE `Group` SET GroupName = ? WHERE (GroupID = ?)";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setString(1, newName);
			preStatement.setInt(2, id);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}
	}

	/*
	 * @see com.vti.backend.businesslayer.IGroupService#delGroupById(int)
	 */
	@Override
	public Boolean delGroupById(int id) throws ClassNotFoundException, SQLException {
		Group groupId = getGroupById(id);
		if (groupId == null) {
			return false;
		} else {
			String sql = "DELETE FROM `Group` WHERE (GroupID = ?)";
			PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
			preStatement.setInt(1, id);
			int result = preStatement.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}
	}
}
