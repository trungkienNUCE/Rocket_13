package com.vti.frontend;

import java.util.Scanner;

public class Exercise4_String {

	public static void main(String[] args) {
//		question1();
//		question2();
//		question3();
//		question4();
//		question5();
//		question6();
//		question7();
//		question8();
//		question9();
//		question10();
//		question11();
//		question12();
//		question13();
//		question14();
//		question15();
		question16();
	}

	private static void question1() {
		System.out.print("Nhap 1 xua ky tu: ");
		Scanner sc = new Scanner(System.in);
		String index = sc.nextLine();
		System.out.println("So luong ky tu cua xau vua nhap la: " + index.length());
		sc.close();
	}

	private static void question2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap xau 1: ");
		String index1 = sc.nextLine();

		System.out.print("Nhap xau 2: ");
		String index2 = sc.nextLine();

		String index = index1.concat(index2);
		System.out.println("index01 + index02: " + index);
		sc.close();
	}

	private static void question3() {
		System.out.print("Nhap ten: ");
		Scanner sc = new Scanner(System.in);
		String ten = sc.nextLine();

		String firstCharacter = ten.substring(0, 1).toUpperCase();
		String rightCharacter = ten.substring(1);

		String ten2 = firstCharacter.concat(rightCharacter);
		System.out.println("Ten cua ban la: " + ten2);
		sc.close();
	}

	private static void question4() {
		System.out.print("Nhap ten: ");
		Scanner sc = new Scanner(System.in);
		String ten = sc.nextLine();

		for (int i = 0; i < ten.length(); i++) {
			System.out.println("Ky tu thu " + (i + 1) + " la: " + ten.charAt(i));
		}
		sc.close();
	}

	private static void question5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ho: ");
		String ho = sc.nextLine();

		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();

		System.out.println("Ho va ten la: " + ho + " " + ten);
		sc.close();
	}

	private static void question6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
//		trim() xoa dau cach o dau va cuoi chuoi
		String name = sc.nextLine().trim();

//		tao mang gom cac từ trong tên tách bơi dấu cách
		String[] words = name.split(" ");

//		Tên = từ cuối cùng
		String ten = words[words.length - 1];
//		họ là từ đầu tiên
		String ho = words[0];

		String tendem = "";
//		chạy từ từ thứ 2 đến từ gần cuối, đó là tên đệm
		for (int i = 1; i <= words.length - 2; i++) {
			tendem += words[i] + " ";
		}

		System.out.println("Họ là: " + ho);
		System.out.println("Tên đệm là: " + tendem);
		System.out.println("Tên là: " + ten);
		sc.close();
	}

	private static void question7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
//		trim() xoa dau cach o dau va cuoi chuoi
		String name = sc.nextLine().trim();

//		tao mang gom cac từ trong tên tách bơi dấu cách

		String ten = "", firstCharacter = "", rightCharacter = "";
		String nameLower = name.toLowerCase();
		String[] words = name.split(" ");

		for (String word : words) {
			firstCharacter = word.substring(0, 1).toUpperCase();
			rightCharacter = word.substring(1);
			word = firstCharacter + rightCharacter;
			ten += word + " ";
		}
		System.out.println("Ten sau khi chuan hoa la: " + ten);

		sc.close();
	}

	private static void question8() {
		String[] Groups = { "Java Script", "Java Core", "Java Spring", "PHP" };
		for (int i = 0; i < Groups.length; i++) {
			if (Groups[i].contains("Java")) {
				System.out.println("Group có chứa chữ Java la: " + Groups[i]);
			}
		}
	}

	private static void question9() {
		String[] Groups = { "Java", "Core", "Java Spring", "PHP" };
		for (int i = 0; i < Groups.length; i++) {
			if (Groups[i].equals("Java")) {
				System.out.println(Groups[i]);
			}
		}

//		for (String group : Groups) {
//			if (group.equals("Java")) {
//				System.out.println(group);
//			}
//		}
	}

//	cau 10
	private static void question10() {
		String index1, index2, reverseIndex1 = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi 1: ");
		index1 = sc.nextLine();
		System.out.print("Nhap chuoi 2: ");
		index2 = sc.nextLine();
		sc.close();
		
		for (int i = index1.length() - 1; i >= 0; i--) {
			reverseIndex1 += index1.substring(i, i + 1);
			}
		if (index2.equals(reverseIndex1)) {
			System.out.println("La chuoi dao nguoc");
		} else {
			System.out.println("Khong la chuoi dao nguoc");
		}
	}
	
//	cau 11
	private static void question11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String index = sc.nextLine();
		sc.close();
		int count = 0;
		for (int i = 0; i < index.length(); i++) {
			if (index.charAt(i) == 'a') {
				count = count + 1;
			}
		}
		System.out.println("So ky tu a la: " + count);
	}

	private static void question12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");

		StringBuffer index = new StringBuffer(sc.nextLine());
		sc.close();
		System.out.println("Chuoi vua nhap: " + index);
		index.reverse();

		System.out.println("Chuoi dao nguoc: " + index);
	}

//	cau 13
	private static void question13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");

		StringBuffer index = new StringBuffer(sc.nextLine());
		sc.close();
		System.out.println("Chuoi vua nhap: " + index);
		for (int i = 0; i < index.length(); i++) {
			if (checkKeyNumber(index.charAt(i))) {
				System.out.println("False");
				return;
			}
		}

		System.out.println("True");
	}

	public static boolean checkKeyNumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}

//	cau 14
	private static void question14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");

		String index = sc.nextLine();
		System.out.println("Chuoi vua nhap: " + index);

		System.out.print("Nhap ky tu muon chuyen: ");
		char ch1 = sc.nextLine().toCharArray()[0];

		System.out.print("Nhap ky tu se chuyen: ");
		char ch2 = sc.nextLine().toCharArray()[0];

		sc.close();

		for (int i = 0; i < index.length(); i++) {
			if (index.charAt(i) == ch1) {
				index = index.replace(ch1, ch2);
			}
		}

		System.out.println("Chuoi sau khi chuyen là: " + index);
	}

//	cau 15

	private static void question15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");

		String index = sc.nextLine();
		System.out.println("Chuoi vua nhap: " + index);

		index = index.trim();
		index = index.replaceAll("\\s+", " ");

		String[] words = index.split(" ");

		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print("Chuoi dao nguoc can tim: " + words[i] + " ");
		}

		sc.close();
	}

	private static void question16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String index = sc.nextLine();
		System.out.println("nhap n = ");
		int n = sc.nextInt();

		if (index == null || index.isEmpty() || index.length() % n != 0) {
			System.out.println("KO");
		} else {
			for (int i = 0; i < index.length(); i = i + n) {
				System.out.println(index.substring(i, i + n));
			}
		}
	}
}
