//
package com.vti.entity;

/**
 * This class is ExperienceCandidate
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class ExperienceCandidate extends Candidate {
	private int expInYear;
	private String proSkill;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString() + "ExperienceCandidate [expInYear=" + expInYear + ", proSkill=" + proSkill + "]";
	}

	public ExperienceCandidate(String userName, String fullName, String phone, String email, String passWord,
			int expInYear, String proSkill) {
		super(userName, fullName, phone, email, passWord);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

}
