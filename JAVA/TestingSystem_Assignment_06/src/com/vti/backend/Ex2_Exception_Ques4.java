package com.vti.backend;

public class Ex2_Exception_Ques4 {

	public void question4() {
		String[] deps = { "dep1", "dep2", "dep3" };
		try {
			System.out.println(deps[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department");
		}

	}
}
