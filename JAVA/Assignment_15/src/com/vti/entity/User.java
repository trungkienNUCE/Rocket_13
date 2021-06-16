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
public class User {
	private int id;
	private String email;
	private String password;
	private String fullName;
	private Role roleUser;

	public enum Role {
		USER, ADMIN
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return roleUser;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.roleUser = role;
	}

	public User(int id, String email, String fullName, Role roleUser) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.roleUser = roleUser;
	}

	public User() {
		super();
	}

}
