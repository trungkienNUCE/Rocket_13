//
package com.vti.entity;

/**
 * This class is FresherCandidate
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public class FresherCandidate extends Candidate {
	private String graduationRank;

	public FresherCandidate(String userName, String fullName, String phone, String email, String passWord,
			String graduationRank) {
		super(userName, fullName, phone, email, passWord);
		this.graduationRank = graduationRank;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	@Override
	public String toString() {
		return super.toString() + "FresherCandidate [graduationRank=" + graduationRank + "]";
	}

}
