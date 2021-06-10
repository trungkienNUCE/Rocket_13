//
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

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
public interface IPositionService {
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException;
	public Position getPosById(int id) throws ClassNotFoundException, SQLException;
}
