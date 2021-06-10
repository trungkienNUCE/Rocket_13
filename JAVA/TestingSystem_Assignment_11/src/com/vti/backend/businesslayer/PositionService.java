//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.entity.Position;

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
public class PositionService implements IPositionService {
	private PositionRepository posRepository;

	public PositionService() throws FileNotFoundException, IOException {
		posRepository = new PositionRepository();
	}

	/*
	 * @see com.vti.backend.businesslayer.IPositionService#getListPosition()
	 */
	@Override
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		return posRepository.getListPosition();
	}

	/*
	 * @see com.vti.backend.businesslayer.IPositionService#getPosById(int)
	 */
	@Override
	public Position getPosById(int id) throws ClassNotFoundException, SQLException {
		return posRepository.getPosById(id);
	}

}
