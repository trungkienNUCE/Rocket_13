//
package com.vti.entity;

/**
 * This class is khai bao project
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 12, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 12, 2021
 */
public class Project {
	private int id;
	private String name;
	private int teamSize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public Project(String name, int teamSize) {
		super();
		this.name = name;
		this.teamSize = teamSize;
	}

	public Project(int id, String name, int teamSize) {
		super();
		this.id = id;
		this.name = name;
		this.teamSize = teamSize;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", teamSize=" + teamSize + "]";
	}

}
