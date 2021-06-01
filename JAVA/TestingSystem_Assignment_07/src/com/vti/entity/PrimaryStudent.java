package com.vti.entity;

public final class PrimaryStudent extends Student {

	public static int counterPrimary = 0;

	public PrimaryStudent(String name) throws Exception {
		super(name);
		counterPrimary++;
	}
}
