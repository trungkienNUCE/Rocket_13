package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	public int id;
	public String name;
	public Account creatorId;
	public LocalDate createDate;
	public Account[] accounts;

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creatorId=" + creatorId + ", createDate=" + createDate
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}

//	a
	public Group(String string, int id2) {
		super();
	}

	public Group(int id, String name, Account creatorId, LocalDate createDate, Account[] accounts) {
		super();
		this.id = id;
		this.name = name;
		this.creatorId = creatorId;
		this.createDate = createDate;
		this.accounts = accounts;
	}

//	b

}
