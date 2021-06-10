//
package com.vti.entity;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 9, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 9, 2021
 */
public class Group {
	private int id;
	private String name;

	public Group(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Group() {
		super();
	}
	
	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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


	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

}
