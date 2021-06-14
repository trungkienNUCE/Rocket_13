////
//package com.vti.backend.businesslayer;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLException;
//
//import com.vti.backend.datalayer.ExperienceCandidateRepository;
//import com.vti.entity.FresherCandidate;
//
///**
// * This class is .
// * 
// * @Description: .
// * @author: TrungKienTran
// * @create_date: Jun 10, 2021
// * @version: 1.0
// * @modifer: TrungKienTran
// * @modifer_date: Jun 10, 2021
// */
//public class ExperienceCandidateService implements ICandidateService, IExperienceCandidateService {
//	private ExperienceCandidateRepository expCanRepos;
//
//	public ExperienceCandidateService() throws FileNotFoundException, IOException {
//		expCanRepos = new ExperienceCandidateRepository();
//	}
//
//	/*
//	 * @see com.vti.backend.businesslayer.IExperienceCandidateService#
//	 * insertExperienceCandidate(java.lang.String, java.lang.String, int,
//	 * java.lang.String, java.lang.String, int, java.lang.String)
//	 */
//	@Override
//	public Boolean insertExperienceCandidate(String userName, String fullName, String phone, String email,
//			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return expCanRepos.insertExperienceCandidate(userName, fullName, phone, email, password, expInYear, proSkill);
//	}
//
//	/*
//	 * @see com.vti.backend.businesslayer.IExperienceCandidateService#
//	 * updateExperienceCandidate(java.lang.String, java.lang.String)
//	 */
//	@Override
//	public Boolean updateExperienceCandidate(String password, String email)
//			throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return expCanRepos.updateExperienceCandidate(password, email);
//	}
//
//	/*
//	 * @see
//	 * com.vti.backend.businesslayer.IExperienceCandidateService#login(java.lang.
//	 * String, java.lang.String)
//	 */
//	@Override
//	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return expCanRepos.login(userName, password);
//	}
//
//}
