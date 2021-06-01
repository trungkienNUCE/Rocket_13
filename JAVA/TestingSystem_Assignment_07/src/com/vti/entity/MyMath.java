package com.vti.entity;

public class MyMath {

	public static int max(int a, int b) {
//		return a > b ? a : b;
		if (a>b) {
			return a;
		} else {
			return b;
		}
	}
	public static int min(int a, int b) {
		return a > b ? b : a;
	}

	public static int sum(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
}
