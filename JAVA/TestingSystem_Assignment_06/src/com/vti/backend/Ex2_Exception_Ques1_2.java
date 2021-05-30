package com.vti.backend;

public class Ex2_Exception_Ques1_2 {

	public void question1_2() {
		try {
			float rs = divide(7, 0);
			System.out.println(rs);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide 0");
		} finally {
			System.out.println("divide completed!");
		}
	}

	private float divide(int a, int b) {
		return a / b;
	}

}
