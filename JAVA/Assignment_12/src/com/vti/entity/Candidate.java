//
package com.vti.entity;

/**
 * This class is khai bao Candidate
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 10, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 10, 2021
 */
public abstract class Candidate {
	private String userName;
	private String fullName;
	private String phone;
	private String email;
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Candidate(String userName, String fullName, String phone, String email, String passWord) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Candidate [userName=" + userName + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email
				+ ", passWord=" + passWord + "]";
	}

}
