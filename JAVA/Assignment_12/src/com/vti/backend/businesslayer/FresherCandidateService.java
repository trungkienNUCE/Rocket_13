//
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.ExperienceCandidateRepository;
import com.vti.backend.datalayer.FresherCandidateRepository;
import com.vti.entity.FresherCandidate;

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
public class FresherCandidateService implements ICandidateService, IFresherCandidateService {
	private FresherCandidateRepository fresherCanRepos;

	public FresherCandidateService() throws FileNotFoundException, IOException {
		fresherCanRepos = new FresherCandidateRepository();
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IFresherCandidateService#insertFresherCandidate
	 * (java.lang.String, java.lang.String, int, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Boolean insertFresherCandidate(String userName, String fullName, String phone, String email, String password,
			String GraduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return fresherCanRepos.insertFresherCandidate(userName, fullName, phone, email, password, GraduationRank);
	}

	/*
	 * @see
	 * com.vti.backend.businesslayer.IFresherCandidateService#updateFresherCandidate
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean updateFresherCandidate(String password, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return fresherCanRepos.updateFresherCandidate(password, email);
	}

	/*
	 * @see com.vti.backend.businesslayer.IFresherCandidateService#login(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return fresherCanRepos.login(userName, password);
	}

}
