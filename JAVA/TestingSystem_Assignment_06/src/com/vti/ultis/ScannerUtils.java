package com.vti.ultis;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

//	cau 7
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.print("Nhập lại: ");
			}
		}
	}

//	cau 8
	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static int inputAge() {
		while (true) {
			int age = inputInt("Wrong inputing! Please input an age as int, input again.");

			if (age <= 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again.");

			} else {
				return age;
			}
		}
	}

//	public static int inputAge() {
//		while (true) {
//			try {
//				int age = inputInt("Wrong inputing! Please input an age as int, input again.");
//
//				if (age <= 0) {
//					System.err.println("Wrong inputing! The age must be greater than 0, please input again.");
//
//				} else {
//					System.err.println("Nhập lại:");
//				}
//			} catch (Exception e) {
//				System.err.println("Nhập lại:");
//			}
//
//		}
//	}

	public static int inputAge2() {

		while (true) {
			try {
				int age = Integer.parseInt(scanner.next());
				if (age >= 0) {
					return age;
				} else {
					System.err.println("Nhập lại (số tuổi lớn hơn 0):");
				}
			} catch (Exception e) {
				System.err.println("Nhập lại (nhập vào 1 số):");

			}
		}
	}

	public static int inputAgeGreaterThan18() {
		while (true) {
			int age = inputAge();

			if (age >= 18) {
				return age;

			} else {
				System.out.println("Wrong inputing! The age must be greater than 18, please input again.");
			}
		}
	}

}
