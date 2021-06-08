package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class PositionDAO {
	private jdbcUltis jdbc;

	public PositionDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public Position getPositionById(int id) throws ClassNotFoundException, SQLException {
		String sql = "Select * from Position where PositionID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Position pos = new Position(resultSet.getInt("PositionID"), resultSet.getString("PositionName"));
			return pos;
		} else {
			jdbc.disConnection();
			return null;
		}

	}
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		String sql = "Select * from Position order by PositionID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Position> listPos = new ArrayList<Position>();

		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt("PositionID"), resultSet.getString("PositionName"));
			listPos.add(pos);
		}
		jdbc.disConnection();
		return listPos;
	}
}
