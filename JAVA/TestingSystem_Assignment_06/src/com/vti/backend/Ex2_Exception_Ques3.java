package com.vti.backend;

public class Ex2_Exception_Ques3 {

	public void question3() {
		int[] nums = { 1, 2, 3 };
		try {
			System.out.println(nums[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Vuot qua gioi han chuoi");
		}
	}
}
