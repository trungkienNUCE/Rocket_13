//
package com.vti.backend.presertationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.ExperienceCandidateService;
import com.vti.backend.businesslayer.IExperienceCandidateService;
import com.vti.entity.FresherCandidate;

/**
 * This class is ExperienceCandidateController
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class ExperienceCandidateController {
	private IExperienceCandidateService experienceCandidateService;

	public ExperienceCandidateController() throws FileNotFoundException, IOException {
		experienceCandidateService = new ExperienceCandidateService();
	}

	public Boolean insertExperienceCandidate(String userName, String fullName, String phone, String email,
			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException {

		return experienceCandidateService.insertExperienceCandidate(userName, fullName, phone, email, password,
				expInYear, proSkill);
	}

	public Boolean login(String userName, String password) throws ClassNotFoundException, SQLException {
		return experienceCandidateService.login(userName, password);
	}

	public Boolean updateExperienceCandidate(String password, String email)
			throws ClassNotFoundException, SQLException {
		return experienceCandidateService.updateExperienceCandidate(password, email);
	}

}
