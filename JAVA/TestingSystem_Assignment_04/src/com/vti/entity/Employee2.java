package com.vti.entity;

public class Employee2 extends User {

	public Employee2(String name, Double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public Double calculatePay() {
		return salaryRatio * 420;
	}

}
