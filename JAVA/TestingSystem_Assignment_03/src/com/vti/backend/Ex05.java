package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.Department2;

public class Ex05 {
	public void question1() {
		Department2[] departments = new Department2[5];

		Department2 department1 = new Department2();
		department1.setId(1);
		department1.setName("Sale");

		Department2 department2 = new Department2();
		department2.setId(2);
		department2.setName("Marketing");

		Department2 department3 = new Department2();
		department3.setId(3);
		department3.setName("Boss of director");

		Department2 department4 = new Department2();
		department4.setId(4);
		department4.setName("Waiting room");

		Department2 department5 = new Department2();
		department5.setId(5);
		department5.setName("Accounting");

		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;

		System.out.println(department1.toString());
	}

	public void question2() {
		Department2 dep1 = new Department2(1, "Phong hop");
		Department2 dep2 = new Department2(2, "Phong GD");
		Department2 dep3 = new Department2(3, "Phong Sale");
		Department2 dep4 = new Department2(4, "Phong A");

		ArrayList<Department2> depArr = new ArrayList<Department2>();
		depArr.add(dep1);
		depArr.add(dep2);
		depArr.add(dep3);
		depArr.add(dep4);

		for (Department2 department2 : depArr) {
			System.out.println(department2.toString());
		}
	}

//	public static void question2() {
//		Department2[] departments = new Department2[5];
//
//		Department2 department1 = new Department2();
//		department1.setId(1);
//		department1.setName("Sale");
//
//		Department2 department2 = new Department2();
//		department2.setId(2);
//		department2.setName("Marketing");
//
//		Department2 department3 = new Department2();
//		department3.setId(3);
//		department3.setName("Boss of director");
//
//		Department2 department4 = new Department2();
//		department4.setId(4);
//		department4.setName("Waiting room");
//
//		Department2 department5 = new Department2();
//		department5.setId(5);
//		department5.setName("Accounting");
//
//		departments[0] = department1;
//		departments[1] = department2;
//		departments[2] = department3;
//		departments[3] = department4;
//		departments[4] = department5;
//
//		for (Department2 department : departments) {
//			System.out.println(department);
//		}
//	}

	public void question3() {
		Department2 dep1 = new Department2(1, "Phong Hop");
		System.out.println("Địa chỉ ô nhớ phòng ban 1 là: " + dep1.hashCode());
	}

	public void question4() {
		Department2 dep1 = new Department2(1, "Phong Hop");
		if (dep1.name.equals("Phong A")) {
			System.out.println("Co ten la phong A");
		} else {
			System.out.println("Khong co");
		}
	}

	public void question5() {
		Department2[] departments = new Department2[5];

		Department2 department1 = new Department2();
		department1.setId(1);
		department1.setName("Sale");

		Department2 department2 = new Department2();
		department2.setId(2);
		department2.setName("Marketing");

		if (department1.equals(department2)) {
			System.out.println("Có bằng nhau !");
		} else {
			System.out.println("Không bằng nhau !");
		}

	}

	public void question6() {
		Department2[] departments = new Department2[5];

		Department2 department1 = new Department2();
		department1.setId(1);
		department1.setName("Sale");

		Department2 department2 = new Department2();
		department2.setId(2);
		department2.setName("Marketing");

		Department2 department3 = new Department2();
		department3.setId(3);
		department3.setName("Boss of director");

		Department2 department4 = new Department2();
		department4.setId(4);
		department4.setName("Waiting room");

		Department2 department5 = new Department2();
		department5.setId(5);
		department5.setName("Accounting");

		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;

		// order by
		for (int i = 0; i < departments.length; i++) {
			for (int j = 0; j < departments.length - 1; j++) {
				if (departments[i].name.compareToIgnoreCase(departments[j].name) < 0) {
					// swap
					Department2 temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
					System.out.println(temp);
				}
			}
		}

	}

	public void question7() {
		Department2[] departments = new Department2[5];

		Department2 department1 = new Department2();
		department1.setId(1);
		department1.setName("Sale");

		Department2 department2 = new Department2();
		department2.setId(2);
		department2.setName("Marketing");

		Department2 department3 = new Department2();
		department3.setId(3);
		department3.setName("Boss of director");

		Department2 department4 = new Department2();
		department4.setId(4);
		department4.setName("Waiting room");

		Department2 department5 = new Department2();
		department5.setId(5);
		department5.setName("Accounting");

		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;

		// order by
		for (int i = 0; i < departments.length; i++) {
			String reverseNameDepartment = reverseWords(departments[i].name);
			for (int j = 0; j < departments.length - 1; j++) {
				String reverseNameComparingDepartment =

						reverseWords(departments[j].name);
				if

				(reverseNameDepartment.compareToIgnoreCase(reverseNameComparingDepartment) < 0) {

					// swap
					Department2 temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}
		// print departments
		for (Department2 department : departments) {
			System.out.println(department);
		}
	}

	private static String reverseWords(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		String[] words = str.split(" ");
		str = "";
		for (int i = words.length - 1; i >= 0; i--) {
			str += words[i] + " ";
		}
		return str.substring(0, str.length() - 2);
	}

}
