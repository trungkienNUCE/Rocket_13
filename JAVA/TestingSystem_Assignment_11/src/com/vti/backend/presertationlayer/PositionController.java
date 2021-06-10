//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IPositionService;
import com.vti.backend.businesslayer.PositionService;
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
public class PositionController implements IPositionService{
	private IPositionService posService;
	
	public PositionController() throws FileNotFoundException, IOException {
		posService = new PositionService();
	}
	/* 
	* @see com.vti.backend.businesslayer.IPositionService#getListPosition()
	*/
	@Override
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return posService.getListPosition();
	}

	/* 
	* @see com.vti.backend.businesslayer.IPositionService#getPosById(int)
	*/
	@Override
	public Position getPosById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return posService.getPosById(id);
	}

}
