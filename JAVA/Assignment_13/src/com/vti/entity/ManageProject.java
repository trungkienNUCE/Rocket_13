//
package com.vti.entity;

/**
 * This class is khai bao manageproject
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class ManageProject {
	private int ProjectId;
	private int AccountId;
	
	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public ManageProject(int projectId, int accountId) {
		super();
		ProjectId = projectId;
		AccountId = accountId;
	}
	public ManageProject() {
		super();
	}
	
}
