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
public class ProjectAndUser {
	private Project project;
	private User user;
	private Role role;

	public enum Role {
		MANAGER, EMPLOYEE
	}
}
