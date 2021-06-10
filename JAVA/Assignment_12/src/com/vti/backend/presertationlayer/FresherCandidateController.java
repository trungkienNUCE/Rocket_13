//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.ExperienceCandidateService;
import com.vti.backend.businesslayer.FresherCandidateService;
import com.vti.backend.businesslayer.IExperienceCandidateService;
import com.vti.backend.businesslayer.IFresherCandidateService;

/**
 * This class is FresherCandidateController
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class FresherCandidateController {
	private IFresherCandidateService fresherCandidateService;

	public FresherCandidateController() throws FileNotFoundException, IOException {
		fresherCandidateService = new FresherCandidateService();
	}

	public Boolean insertFresherCandidate(String userName, String fullName, String phone, String email, String password,
			String GraduationRank) throws ClassNotFoundException, SQLException {
		return fresherCandidateService.insertFresherCandidate(userName, fullName, phone, email, password,
				GraduationRank);
	}

	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException {
		return fresherCandidateService.login(userName, password);
	}

	public Boolean updateExperienceCandidate(String password, String email)
			throws ClassNotFoundException, SQLException {
		return fresherCandidateService.updateFresherCandidate(password, email);
	}

}
