package com.vti.frontend;

public class Exercise3_Boxing_UnBoxing {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
	}

	private static void question1() {
		int salary = 5000;
		float salary2 = salary;
		System.out.printf("Lương sau khi convert là: %.2f %n", salary2);
	}

	private static void question2() {
		String a = new String("1234567");
		int b = Integer.parseInt(a);
		System.out.println("Convert String trên thành datatype int: " + b);
	}

	private static void question3() {
		Integer a = new Integer("123456");
		int b = a.intValue();
		System.out.println("Convert số trên thành datatype int: " + b);

	}
}
