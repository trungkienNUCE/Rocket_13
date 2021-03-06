//
package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.FresherCandidate;

/**
 * This class is interface IFresherCandidateRepository
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public interface IFresherCandidateRepository {
	public Boolean insertFresherCandidate(String userName, String fullName, String phone, String email, String password,
			String GraduationRank) throws ClassNotFoundException, SQLException;

	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException;

	public boolean updateFresherCandidate(String password, String email) throws ClassNotFoundException, SQLException;

}
