package com.vti.entity;

import com.vti.backend.Gender;

public class Worker extends Staff {
	private int rank;

	public Worker(String name, int age, Gender gender, String address, int rank) {
		super(name, age, gender, address);
		this.rank = rank;
	}
	@Override
	public String toString() {
		return super.toString() + " Cấp bậc: " + rank + "]";
	}

	
	
}
