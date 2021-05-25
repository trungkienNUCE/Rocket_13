package com.vti.entity;

import com.vti.backend.Gender;

public class Engineer extends Staff {
	private String specialized;

	@Override
	public String toString() {
		return super.toString() + " specialized=" + specialized;
	}

	public Engineer(String name, int age, Gender gender, String address, String specialized) {
		super(name, age, gender, address);
		this.specialized = specialized;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}
	
	
}
