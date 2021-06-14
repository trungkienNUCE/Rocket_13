//
package com.vti.entity;

/**
 * This class is khai bao account
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class Account {
	private int id;
	private String fullName;
	private String email;
	private String passWord;
	private int expInYear;
	private String proSkill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
		return "Account [id=" + id + ", fullName=" + fullName + ", email=" + email + ", passWord=" + passWord
				+ ", expInYear=" + expInYear + ", proSkill=" + proSkill + "]";
	}

	public Account(String fullName, String email, int expInYear, String proSkill) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public Account(int id, String fullName, String email, String passWord, int expInYear, String proSkill) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.passWord = passWord;
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public Account(String fullName, String email) {
		super();
		this.fullName = fullName;
		this.email = email;
	}

	public Account() {
		super();
	}

}
