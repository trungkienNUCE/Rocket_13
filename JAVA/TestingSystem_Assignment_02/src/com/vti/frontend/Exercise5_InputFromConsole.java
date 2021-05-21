package com.vti.frontend;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Exercise5_InputFromConsole {

	public static void main(String[] args) {
//		Question1
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("nhap a,b,c = ");
//		if (scanner.hasNextInt()) {
//			int a = scanner.nextInt();
//			int b = scanner.nextInt();
//			int c = scanner.nextInt();
//			System.out.println("Ban vua nhap 3 so la: " + a + "," + b + "," + c);
//		} else {
//			System.out.println("Ban vua nhap khong phai so");
//		}
//		scanner.close();

//		Question2
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("nhap so thuc a,b = ");
//		if (scanner.hasNextFloat()) {
//			float a = scanner.nextFloat();
//			float b = scanner.nextFloat();
//			System.out.println("Ban vua nhap 3 so la: " + a + "," + b);
//		} else {
//			System.out.println("Ban vua nhap khong phai so");
//		}	
//		scanner.close();

//		Question3
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("nhap ho ten: ");
//			String ht = scanner.nextLine();
//			System.out.println("Ho va ten cua ban la: " + ht);
//		scanner.close();

//		Question4
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("Nhap ngay sinh cua ban theo dinh dang (Ngay/thang/nam): ");
//		String dateString = scanner.next();
//
//		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày,
//								// năm có 12 tháng,....
//		try {
//			df.parse(dateString); // parse dateString thành kiểu Date
//			System.out.println("Ngay sinh cua ban la: " + dateString);
//		} catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
//			System.out.println("Loi dinh dang ngay");
//		}
//		scanner.close();

//		creatAccount();
//		creatDepartment();
//		nhapSoChan();
//		question9();

		Scanner sc = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-45s  |%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|		Nhập chức năng			 |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Tao nhan vien");
			System.out.format(leftAlign, "2. Tao phong ban");
			System.out.format(leftAlign, "3. Them Account vao Group");
			System.out.format(leftAlign, "4. Them Account vao Group ngau nhien");
			System.out.format(leftAlign, "5. Thoat");
			System.out.format("+------------------------------------------------+%n");

			choose = sc.nextInt();
			switch (choose) {
			case 1:
				creatAccount();
				break;
			case 2:
				creatDepartment();
				break;
			case 3:
				question9();
				break;

			case 4:
				addAccToRandomGroup();
				break;
			case 5:
				break;
			}
			System.out.println("Bạn có muốn tiếp tục không?");
			System.out.println("Co - để tiếp tục, Nhập bất kỳ để thoát");
			String tt = sc.next();
			if (tt.equals("Co")) {
				System.out.println("Nhap lai");
			} else {
				System.out.println("Good Bye!");
				return;
			}
		}
	}

//	Question 5
	public static void creatAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Them moi 1 nhan vien");
		Account account1 = new Account();
		System.out.print("nhap id = ");
		account1.id = scanner.nextInt();
		System.out.print("nhap fullname = ");
		account1.fullName = scanner.next();
		System.out.print("nhap usename = ");
		account1.userName = scanner.next();
		System.out.print("nhap email = ");
		account1.email = scanner.next();
		System.out.println("Nhap position");
		int posNum = scanner.nextInt();

		switch (posNum) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.DEV;
			account1.position = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.TEST;
			account1.position = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.SCRUM_MASTER;
			account1.position = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			account1.position = pos4;
			break;
		default:
			break;
		}
		System.out.println("Thong tin nhan vien vua nhap la:");
		System.out.println("Id: " + account1.id);
		System.out.println("Email: " + account1.email);
		System.out.println("FullName: " + account1.fullName);
		System.out.println("userName: " + account1.userName);
		System.out.println("Position: " + account1.position.name);
	}

//	Question 6
	private static void creatDepartment() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap thong tin phong ban");
		Department dep1 = new Department();
		System.out.print("nhap id = ");
		dep1.id = scanner.nextInt();
		System.out.print("nhap ten phong = ");
		dep1.name = scanner.next();
		System.out.println("Thong tin phong ban vua nhap la:");
		System.out.println("Id phong: " + dep1.id);
		System.out.println("ten phong: " + dep1.name);
	}

//	Question 7: Nhập số chẵn từ console
	private static void nhapSoChan() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("nhap 1 so chan ");
		if (scanner.hasNextInt()) {
			int a = scanner.nextInt();
			if (a % 2 == 0) {
				System.out.println("So chan ban vua nhap la: " + a);
			} else {
				System.out.println("Ban vua nhap so le roi");
			}
		} else {
			System.out.println("Ban vua nhap vao 1 chuoi roi");
		}
		scanner.close();
	}

	private static void question9() {
//		tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Sale";
		group1.createDate = LocalDate.of(2020, 8, 1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2021, 3, 1);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Testing_System";
		group3.createDate = LocalDate.of(2020, 1, 1);

//		tao account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "trantrungkien@gmail.com";
		acc1.userName = "trungkien";
		acc1.fullName = "Tran Trung Kien";
		acc1.createDate = LocalDate.of(2011, 8, 9);
//		Group[] groupAcc1 = { group1, group2, group3 };
//		acc1.groups = groupAcc1;

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "account02@gmail.com";
		acc2.userName = "account02";
		acc2.fullName = "Full Name 02";
		acc2.createDate = LocalDate.of(2020, 12, 20);
//		Group[] groupAcc2 = { group1, group3 };
//		acc2.groups = groupAcc2;

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "account03@gmail.com";
		acc3.userName = "account03";
		acc3.fullName = "Full Name 03";
		acc3.createDate = LocalDate.now();
//		Group[] groupAcc3 = { group2 };
//		acc3.groups = groupAcc3;

		System.out.println("Danh sach User tren he thong la: ");
		Account[] accArr = { acc1, acc2, acc3 };
		for (int i = 0; i < accArr.length; i++) {
			System.out.println(+(i + 1) + ". " + accArr[i].userName);
		}
		System.out.println("---------------------");

		System.out.println("Danh sach Group tren he thong la: ");
		Group[] groupArr = { group1, group2, group3 };
		for (int i = 0; i < groupArr.length; i++) {
			System.out.println(+(i + 1) + ". " + groupArr[i].name);
		}
		System.out.println("---------------------");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Username: ");
		String userName = scanner.next();
		System.out.println("---------------------");

		System.out.println("Nhap Group: ");
		String groupName = scanner.next();
		System.out.println("---------------------");
//		nếu tên nhập vào khác với user có sẵn thì gán index = -1, không thì gán index = 1 để sau lấy giá trị trong mảng
		int indexAccount = -1;
		for (int i = 0; i < accArr.length; i++) {
			if (accArr[i].userName.equals(userName)) {
				indexAccount = i;
			}
		}
		int indexGroup = -1;
		for (int i = 0; i < groupArr.length; i++) {
			if (groupArr[i].name.equals(groupName)) {
				indexGroup = i;
			}
		}
		if (indexAccount == -1 || indexGroup == -1) {
			System.out.println("Ban nhap sai ten UserName hoac Group. Vui long kiem tra lai!");
		} else {
			for (int i = 0; i < accArr.length; i++) {
				if (accArr[i].userName.equals(userName)) {
					Group[] groupAdd = { groupArr[indexGroup] };
					accArr[i].groups = groupAdd;
					System.out.println("Ban vua them group " + accArr[indexAccount].groups[0].name + " cho UserName: "
							+ accArr[indexAccount].userName);
				}
			}
		}
	}

	private static void addAccToRandomGroup() {
		// tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Sale";
		group1.createDate = LocalDate.of(2020, 8, 1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2021, 3, 1);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Testing_System";
		group3.createDate = LocalDate.of(2020, 1, 1);

		// tao account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "trantrungkien@gmail.com";
		acc1.userName = "trungkien";
		acc1.fullName = "Tran Trung Kien";
		acc1.createDate = LocalDate.of(2011, 8, 9);
		// Group[] groupAcc1 = { group1, group2, group3 };
		// acc1.groups = groupAcc1;

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "account02@gmail.com";
		acc2.userName = "account02";
		acc2.fullName = "Full Name 02";
		acc2.createDate = LocalDate.of(2020, 12, 20);
		// Group[] groupAcc2 = { group1, group3 };
		// acc2.groups = groupAcc2;

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "account03@gmail.com";
		acc3.userName = "account03";
		acc3.fullName = "Full Name 03";
		acc3.createDate = LocalDate.now();
		// Group[] groupAcc3 = { group2 };
		// acc3.groups = groupAcc3;

		System.out.println("Danh sach User tren he thong la: ");
		Account[] accArr = { acc1, acc2, acc3 };
		for (int i = 0; i < accArr.length; i++) {
			System.out.println(+(i + 1) + ". " + accArr[i].userName);
		}
		System.out.println("---------------------");

		System.out.println("Danh sach Group tren he thong la: ");
		Group[] groupArr = { group1, group2, group3 };
		for (int i = 0; i < groupArr.length; i++) {
			System.out.println(+(i + 1) + ". " + groupArr[i].name);
		}
		System.out.println("---------------------");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Username: ");
		String userName = scanner.next();
		System.out.println("---------------------");

		Random random = new Random();
		int indexGroup = random.nextInt(2);

		int indexAccount = -1;
		for (int i = 0; i < accArr.length; i++) {
			if (accArr[i].userName.equals(userName)) {
				indexAccount = i;
			}
		}

		if (indexAccount == -1) {
			System.out.println("Ban nhap sai ten UserName. Vui long kiem tra lai!");
		} else {
			for (int i = 0; i < accArr.length; i++) {
				if (accArr[i].userName.equals(userName)) {
					Group[] groupAdd = { groupArr[indexGroup] };
					accArr[i].groups = groupAdd;
					System.out.println("Ban vua them group " + accArr[indexAccount].groups[0].name + " cho UserName: "
							+ accArr[indexAccount].userName);
				}
			}
		}
	}

}
