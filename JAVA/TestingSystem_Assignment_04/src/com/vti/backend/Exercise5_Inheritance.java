package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Group;
import com.vti.entity.HighSchoolStudent;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Staff;
import com.vti.entity.Worker;

public class Exercise5_Inheritance {
	ArrayList<Staff> staffList = new ArrayList<Staff>();
	Scanner sc = new Scanner(System.in);

	public void question2() {
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Thêm mới cán bộ");
			System.out.format(leftAlign, "2. Tìm kiếm theo họ tên");
			System.out.format(leftAlign, "3. Hiển thị thông tin về danh sách các cán bộ");
			System.out.format(leftAlign, "4. Nhập vào tên của cán bộ và delete cán bộ đó");
			System.out.format(leftAlign, "5. Thoát");
			System.out.format("+-------------------------------------------------+%n");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				addStaff();
				break;
			case 2:
				search();
				break;
			case 3:
				print();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1 - để tiếp tục, Nhập bất kỳ để thoát");
				String tt1 = sc.next();
				if (tt1.equals("1")) {
					System.out.println("Nhập lại chức năng");
					break;
				} else {
					System.out.println("Good Bye!");
					return;
				}
			default:
				System.out.println("Nhập lại");
				break;
			}
		}
	}

	private void delete() {
		System.out.println("Nhập tên cán bộ cần xoá");
		String delName = sc.next();
		staffList.removeIf(staff -> staff.getName().equals(delName));
		System.out.println("Danh sách cán bộ còn lại là: ");
		for (Staff staff : staffList) {
			System.out.println(staff);
		}
	}

	private void print() {
		System.out.println("Danh sách cán bộ là: ");
		for (Staff staff : staffList) {
			System.out.println(staff);
		}
	}

	private void search() {
		System.out.println("Tìm kiếm tên: ");
		String searchName = sc.next();
		for (Staff staff : staffList) {
			if (staff.getName().equals(searchName)) {
				System.out.println("Thông tin cán bộ cần tìm là: " + staff);
			}
		}
	}

	private void addStaff() {
		String leftAlign = "| %-46s  |%n";
		System.out.format("+-------------------------------------------------+%n");
		System.out.format(leftAlign, "1. Thêm mới công nhân");
		System.out.format(leftAlign, "2. Thêm mới kỹ sư");
		System.out.format(leftAlign, "3. Thêm mới nhân viên");
		System.out.format("+-------------------------------------------------+%n");
		int choose1 = sc.nextInt();
		switch (choose1) {
		case 1:
			System.out.println("-----Thêm thông tin công nhân-----");
			System.out.println("Tên công nhân:");
			String nameWorker = sc.next();

			System.out.println("Tuổi:");
			int ageWorker = sc.nextInt();

			System.out.println("Giới tính: (1.Male 2.Female 3.Unknown)");
			int flagGender = sc.nextInt();
			Gender gender = Gender.UNKNOW;
			switch (flagGender) {
			case 1:
				gender = Gender.MALE;
				break;
			case 2:
				gender = Gender.FEMALE;
				break;
			case 3:
				gender = Gender.UNKNOW;
				break;
			default:
				break;
			}

			System.out.println("Địa chỉ: ");
			String addressWorker = sc.next();

			System.out.println("Cấp bậc: ");
			int rankWorker = sc.nextInt();

//			them cong nhan vao danh sach arraylist
			Staff worker = new Worker(nameWorker, ageWorker, gender, addressWorker, rankWorker);
			staffList.add(worker);
			break;

		case 2:
			System.out.println("-----Thêm thông tin kỹ sư-----");
			System.out.println("Tên kỹ sư:");
			String nameEngineer = sc.next();

			System.out.println("Tuổi:");
			int ageEngineer = sc.nextInt();

			System.out.println("Giới tính: (1.Male 2.Female 3.Unknown)");
			int flagGender2 = sc.nextInt();
			Gender gender2 = Gender.UNKNOW;
			switch (flagGender2) {
			case 1:
				gender2 = Gender.MALE;
				break;
			case 2:
				gender2 = Gender.FEMALE;
				break;
			case 3:
				gender2 = Gender.UNKNOW;
				break;
			default:
				break;
			}

			System.out.println("Địa chỉ: ");
			String addressEngineer = sc.next();

			System.out.println("Ngành học: ");
			String specialized = sc.next();

//			them cong nhan vao danh sach arraylist
			Staff engineer = new Engineer(nameEngineer, ageEngineer, gender2, addressEngineer, specialized);
			staffList.add(engineer);
			break;

		case 3:
			System.out.println("-----Thêm thông tin nhân viên-----");
			System.out.println("Tên nhân viên:");
			String nameEmployee = sc.next();
			System.out.println("Tuổi:");
			int ageEmployee = sc.nextInt();
			System.out.println("Giới tính: (1.Male 2.Female 3.Unknown)");
			int flagGender3 = sc.nextInt();
			Gender gender3 = Gender.UNKNOW;
			switch (flagGender3) {
			case 1:
				gender3 = Gender.MALE;
				break;
			case 2:
				gender3 = Gender.FEMALE;
				break;
			case 3:
				gender3 = Gender.UNKNOW;
				break;
			default:
				break;
			}
			System.out.println("Địa chỉ: ");
			String addressEmployee = sc.next();

			System.out.println("Công việc");
			String task = sc.next();

//			them cong nhan vao danh sach arraylist
			Staff Employee = new Employee(nameEmployee, ageEmployee, gender3, addressEmployee, task);
			staffList.add(Employee);
			break;

		default:
			System.out.println("Nhập sai chức năng!");
			break;
		}
	}

	public void question3() {
		HighSchoolStudent HSS = new HighSchoolStudent(1, "Kien", "Rocket13", "DHXD");
		System.out.println(HSS.toString());
		
		
		
		
	}
}
