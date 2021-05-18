package com.vti.frontend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.Position.PositionName;
import com.vti.entity.TypeQuestion.TypeName;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class Exercise1_Flow_Control {

	public static void main(String[] args) {
//		tao department
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Waiting Zoom";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Meeting";

		Department dep4 = new Department();
		dep4.id = 4;
		dep4.name = "Sale";

//			tao position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.SCRUM_MASTER;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.TEST;

//			tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";
//			group1.creatorId = 2;
		group1.createDate = LocalDate.of(2020, 8, 1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2020, 3, 1);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Testing System";
		group3.createDate = LocalDate.of(2020, 1, 1);

//			tao account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "trantrungkien@gmail.com";
		acc1.userName = "trungkien";
		acc1.fullName = "Tran Trung Kien";
		acc1.position = pos1;
		acc1.department = dep1;
		acc1.createDate = LocalDate.of(2011, 8, 9);
		Group[] groupAcc1 = { group1, group2, group3 };
		Department[] depAcc1 = { dep1, dep2 };
		acc1.groups = groupAcc1;

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "account02@gmail.com";
		acc2.userName = "account02";
		acc2.fullName = "Full Name 02";
		acc2.position = pos3;
		acc2.department = dep1;
		acc2.createDate = LocalDate.of(2020, 12, 20);
		Group[] groupAcc2 = { group1, group3 };
		Department[] depAcc2 = { dep1, dep2 };
		acc2.groups = groupAcc2;

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "account03@gmail.com";
		acc3.userName = "account03";
		acc3.fullName = "Full Name 03";
		acc3.position = pos2;
		acc3.department = dep1;
		acc3.createDate = LocalDate.now();
		Group[] groupAcc3 = { group2 };
		Department[] depAcc3 = { dep2 };
		acc3.groups = groupAcc3;

//			tao GroupAccount
		GroupAccount groupaccount1 = new GroupAccount();
		groupaccount1.id = group1;
		groupaccount1.accountId = acc2;
		groupaccount1.joinDate = LocalDate.of(2021, 1, 28);

		GroupAccount groupaccount2 = new GroupAccount();
		groupaccount2.id = group2;
		groupaccount2.accountId = acc1;
		groupaccount2.joinDate = LocalDate.of(2020, 2, 1);

		GroupAccount groupaccount3 = new GroupAccount();
		groupaccount3.id = group3;
		groupaccount3.accountId = acc3;
		groupaccount3.joinDate = LocalDate.of(2020, 12, 1);

//			tao TypeQuestion
		TypeQuestion typequestion1 = new TypeQuestion();
		typequestion1.id = 1;
		typequestion1.name = TypeName.ESSAY;

		TypeQuestion typequestion2 = new TypeQuestion();
		typequestion2.id = 2;
		typequestion2.name = TypeName.MULATIPLE_CHOICE;

//			Tao CategoryQuestion
		CategoryQuestion catequestion01 = new CategoryQuestion();
		catequestion01.id = 1;
		catequestion01.name = "Java";

		CategoryQuestion catequestion02 = new CategoryQuestion();
		catequestion02.id = 2;
		catequestion02.name = "SQL";

		CategoryQuestion catequestion03 = new CategoryQuestion();
		catequestion03.id = 3;
		catequestion03.name = "PHP";

//			Tao Question
		Question question01 = new Question();
		question01.id = 1;
		question01.content = "Hoc Java trong bao lau?";
		question01.categoryId = catequestion01;
		question01.typeId = typequestion1;
		question01.accountId = acc1;
		question01.createDate = LocalDate.of(2021, 05, 01);

		Question question02 = new Question();
		question02.id = 2;
		question02.content = "Hoc Java co kho khong?";
		question02.categoryId = catequestion01;
		question02.typeId = typequestion2;
		question02.accountId = acc3;
		question02.createDate = LocalDate.of(2020, 12, 01);

		Question question03 = new Question();
		question03.id = 3;
		question03.content = "SQL la gi?";
		question03.categoryId = catequestion02;
		question03.typeId = typequestion2;
		question03.accountId = acc2;
		question03.createDate = LocalDate.of(2020, 8, 01);

//			Tao Answer
		Answer answer01 = new Answer();
		answer01.id = 1;
		answer01.content = "Hoc Java trong 1 nam";
		answer01.questionId = question01;
//			answer01.isCorrect = 

		Answer answer02 = new Answer();
		answer02.id = 2;
		answer02.content = "Hoc Java trong 4.5 thang";
		answer02.questionId = question01;

		Answer answer03 = new Answer();
		answer03.id = 3;
		answer03.content = "SQL la ngon ngu truy van co cau truc";
		answer03.questionId = question03;

//			tao Exam
		Exam exam01 = new Exam();
		exam01.id = 1;
		exam01.code = "VTI001";
		exam01.title = "De thi Java";
		exam01.categoryId = catequestion01;
		exam01.duration = 90;
		exam01.creatorId = acc1;
		exam01.createDate = LocalDate.of(2021, 5, 1);

		Exam exam02 = new Exam();
		exam02.id = 2;
		exam02.code = "VTI002";
		exam02.title = "De thi SQL";
		exam02.categoryId = catequestion02;
		exam02.duration = 60;
		exam02.creatorId = acc3;
		exam02.createDate = LocalDate.of(2021, 4, 1);

		Exam exam03 = new Exam();
		exam03.id = 3;
		exam03.code = "VTI003";
		exam03.title = "De thi PHP";
		exam03.categoryId = catequestion03;
		exam03.duration = 120;
		exam03.creatorId = acc2;
		exam03.createDate = LocalDate.of(2021, 1, 1);

//			tao ExamQuestion
		ExamQuestion examquestion01 = new ExamQuestion();
		examquestion01.examId = exam01;
		examquestion01.questionId = question02;

		ExamQuestion examquestion02 = new ExamQuestion();
		examquestion02.examId = exam02;
		examquestion02.questionId = question01;

//			IF....ELSE
//			Question 1
//		System.out.println("Question 1:");
//		if (acc2.department == null) {
//			System.out.println("Nhan vien chua co phong ban");
//
//		} else {
//			System.out.println("Phong cua nhan vien " + acc2.fullName + " la: " + acc2.department.name);
//		}
//
////			Question 2
//		System.out.println("Question 2:");
//		if (acc2.groups == null) {
//			System.out.println("Nhan vien chua co group");
//		} else {
//			int countGroup = acc2.groups.length;
//
//			if (countGroup == 1 || countGroup == 2) {
//				System.out.println("Nhan vien nay la java fresher va c# fresher");
//			}
//			if (countGroup == 3) {
//				System.out.println("Nhan vien nay rat quan trong, tham gia nhieu group");
//			}
//			if (countGroup == 4) {
//				System.out.println("Nhan vien nay la nguoi hong chuyen, group nao cung co mat");
//			}
//		}
//
////			Question 3
//		System.out.println("Question 3:");
//
//		System.out.println(acc2.department == null ? "Nhan vien nay chua co phong ban"
//				: "Phong cua nhan vien " + acc2.fullName + " la: " + acc2.department.name);
//
////			Question 4
//		System.out.println("Question 4:");
//
//		System.out.println(
//				acc1.position.name == PositionName.DEV ? "Day la Developer" : "Nguoi nay khong phai la Developer");
//
////			SWITHCH CASE
////			Question 5
//		Group group4 = new Group();
//		group4.id = 1;
//		group4.name = "Sale";
//		group4.createDate = LocalDate.of(2020, 8, 1);
//		Account[] accGroup4 = { acc1, acc2 };
//		group4.accounts = accGroup4;
//
//		System.out.println("Question 5:");
//		if (group4.accounts == null) {
//			System.out.println("Nhom nay chua co phong");
//
//		} else {
//			int countAccInGroup = group4.accounts.length;
//			switch (countAccInGroup) {
//			case 1:
//				System.out.println("Nhom co 1 thanh vien");
//				break;
//
//			case 2:
//				System.out.println("Nhom co 2 thanh vien");
//				break;
//
//			case 3:
//				System.out.println("Nhom co 3 thanh vien");
//				break;
//			default:
//				System.out.println("Nhom nay co nhieu thanh vien");
//				break;
//			}
//		}
//
////			Question 6
//		System.out.println("Question 6:");
//		if (acc1.groups == null) {
//			System.out.println("Nhan vien chua co group");
//		} else {
//			int countGroup = acc1.groups.length;
//			switch (countGroup) {
//			case 1:
//				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
//				break;
//			case 2:
//				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
//				break;
//			case 3:
//				System.out.println("Nhân viên này là người quan trọng");
//				break;
//
//			default:
//				System.out.println("Nhân viên này là người hóng chuyện");
//				break;
//			}
//		}
//
////			Question 7
//		System.out.println("Question 7:");
//		PositionName positionName = acc1.position.name;
//		switch (positionName) {
//		case DEV:
//			System.out.println("Day la Developer");
//			break;
//		default:
//			System.out.println("Nhan vien nay khong phai la Developer");
//			break;
//		}
//
////			Question 8
//		System.out.println("Question 8:");
//		Account[] accArray1 = { acc1, acc2, acc3 };
//
//		for (Account account : accArray1) {
//			System.out.println("Email:      " + account.email);
//			System.out.println("Fullname:   " + account.fullName);
//			System.out.println("Department: " + account.department.name);
//			System.out.println("------------------");
//		}
//
////			Question 9
//		System.out.println("Question 9:");
//		Department[] depArr = { dep1, dep2, dep3 };
//
//		for (Department department : depArr) {
//			System.out.println("Id phong:      " + department.id);
//			System.out.println("Ten phong:   " + department.name);
//			System.out.println("------------------");
//		}
//			
////		FOR
////			Question 10
//		System.out.println("Question 10:");
//		Account[] accArr = { acc1, acc2, acc3 };
//		for (int i = 0; i < accArr.length; i++) {
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("Email la: " + accArr[i].email);
//			System.out.println("Fullnam la: " + accArr[i].fullName);
//			System.out.println("Phong ban: " + accArr[i].department.name);
//			System.out.println("--------------------");
//		}
//
////			Question 11
//		System.out.println("Question 11:");
//		Department[] depArr2 = { dep1, dep2, dep3 };
//		for (int i = 0; i < depArr.length; i++) {
//			System.out.println("Thong tin cua phong ban thu " + (i + 1) + " la:");
//			System.out.println("Id la: " + depArr2[i].id);
//			System.out.println("Ten phong la: " + depArr2[i].name);
//			System.out.println("------------------");
//		}
//
////			Question 12
//		System.out.println("Question 12:");
//		Department[] depArr3 = { dep1, dep2, dep3 };
//		for (int i = 0; i < 2; i++) {
//			System.out.println("Thong tin cua phong ban thu " + (i + 1) + " la:");
//			System.out.println("Id la: " + depArr3[i].id);
//			System.out.println("Ten phong la: " + depArr3[i].name);
//			System.out.println("------------------");
//		}
//
////			Question 13
//		System.out.println("Question 13:");
//		Account[] accArr2 = { acc1, acc2, acc3 };
//		for (int i = 0; i < accArr2.length; i++) {
//			if (i == 1) {
//				continue;
//			}
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("Email la: " + accArr2[i].email);
//			System.out.println("Fullnam la: " + accArr2[i].fullName);
//			System.out.println("Phong ban: " + accArr2[i].department.name);
//			System.out.println("--------------------");
//		}
//
////			Question 14
//		System.out.println("Question 14:");
//		Account[] accArr3 = { acc1, acc2, acc3 };
//		for (int i = 0; i < accArr3.length; i++) {
//			if (accArr3[i].id >= 3) {
//				continue;
//			}
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("ID la: " + accArr3[i].id);
//			System.out.println("Email la: " + accArr3[i].email);
//			System.out.println("Fullnam la: " + accArr3[i].fullName);
//			System.out.println("Phong ban: " + accArr3[i].department.name);
//			System.out.println("--------------------");
//		}
////			Question 15
//		for (int i = 0; i <= 20; i++) {
//			if (i % 2 == 0) {
//				System.out.print(i + " ");
//			}		

//		WHILE
//			Question 10
			System.out.println("Question 10 While:");
			Account[] accArr = { acc1, acc2, acc3 };
			int i = 0;
			while (i < accArr.length) {
				System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
				System.out.println("Email la: " + accArr[i].email);
				System.out.println("Fullnam la: " + accArr[i].fullName);
				System.out.println("Phong ban: " + accArr[i].department.name);
				System.out.println("--------------------");
				i++;
			}

//		Question 11
//		System.out.println("Question 11 While:");
//		Department[] depArr2 = { dep1, dep2, dep3 };
//		int i = 0;
//		while (i < depArr2.length) {
//			System.out.println("Thong tin cua phong ban thu " + (i + 1) + " la:");
//			System.out.println("Id la: " + depArr2[i].id);
//			System.out.println("Ten phong la: " + depArr2[i].name);
//			System.out.println("------------------");
//			i++;
//		}

//		Question 12
//		System.out.println("Question 12 While:");
//		Department[] depArr3 = { dep1, dep2, dep3 };
//		int i = 0;
//		while (i < 2) {
//			System.out.println("Thong tin cua phong ban thu " + (i + 1) + " la:");
//			System.out.println("Id la: " + depArr3[i].id);
//			System.out.println("Ten phong la: " + depArr3[i].name);
//			System.out.println("------------------");
//			i++;
//		}
		
		
//		Question 13
//		System.out.println("Question 13 While:");
//		Account[] accArr2 = { acc1, acc2, acc3 };
//		int i = 0;
//		while ( i < accArr2.length ) {
//			if (i == 1) {
//				i++;
//				continue;
//			}
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("Email la: " + accArr2[i].email);
//			System.out.println("Fullnam la: " + accArr2[i].fullName);
//			System.out.println("Phong ban: " + accArr2[i].department.name);
//			System.out.println("--------------------");
//			i++;
//		}
		
//		Question 14
//		System.out.println("Question 14 While:");
//		Account[] accArr3 = { acc1, acc2, acc3 };
//		int i = 0;
//		while (i < accArr3.length) {
//			if (accArr3[i].id >= 3) {
//				i++;
//				continue;
//			}
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("ID la: " + accArr3[i].id);
//			System.out.println("Email la: " + accArr3[i].email);
//			System.out.println("Fullnam la: " + accArr3[i].fullName);
//			System.out.println("Phong ban: " + accArr3[i].department.name);
//			System.out.println("--------------------");
//			i++;
//		}
		
//			Question 15
//			int a = 0;
//			while (a <= 20) {
//				if (a % 2 == 0) {
//					System.out.print(a + " ");
//				}
//				a++;
//			}

//		DO WHILE
//		Question 10
//		System.out.println("Question 10 Do While:");
//		Account[] accArr = { acc1, acc2, acc3 };
//		int i = 0;
//		do {
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("Email la: " + accArr[i].email);
//			System.out.println("Fullnam la: " + accArr[i].fullName);
//			System.out.println("Phong ban: " + accArr[i].department.name);
//			System.out.println("--------------------");
//			i++;
//		} while (i < accArr.length);
		
//		Question 11
//		System.out.println("Question 11 Do While:");
//		Department[] depArr2 = { dep1, dep2, dep3 };
//		int i = 0;
//		do {
//			System.out.println("Thong tin cua phong ban thu " + (i + 1) + " la:");
//			System.out.println("Id la: " + depArr2[i].id);
//			System.out.println("Ten phong la: " + depArr2[i].name);
//			System.out.println("------------------");
//			i++;
//		} while (i < depArr2.length);
		
//		Question 12
//		System.out.println("Question 12 Do While:");
//		Department[] depArr3 = { dep1, dep2, dep3 };
//		int i = 0;
//		do {
//			System.out.println("Thong tin cua phong ban thu " + (i + 1) + " la:");
//			System.out.println("Id la: " + depArr3[i].id);
//			System.out.println("Ten phong la: " + depArr3[i].name);
//			System.out.println("------------------");
//			i++;
//		} while (i < 2);
		
//		Question 13
//		System.out.println("Question 13 Do While:");
//		Account[] accArr2 = { acc1, acc2, acc3 };
//		int i = 0;
//
//		do {
//			if (i == 1) {
//				i++;
//				continue;
//			}
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("Email la: " + accArr2[i].email);
//			System.out.println("Fullnam la: " + accArr2[i].fullName);
//			System.out.println("Phong ban: " + accArr2[i].department.name);
//			System.out.println("--------------------");
//			i++;
//		} while (i < accArr2.length);
		
//		
//		Question 14
//		System.out.println("Question 14 Do While:");
//		Account[] accArr3 = { acc1, acc2, acc3 };
//		int i = 0;
//		do {
//			if (accArr3[i].id >= 3) {
//				i++;
//				continue;
//			}
//			System.out.println("Thong tin cua nhan vien thu " + (i + 1) + " la:");
//			System.out.println("ID la: " + accArr3[i].id);
//			System.out.println("Email la: " + accArr3[i].email);
//			System.out.println("Fullnam la: " + accArr3[i].fullName);
//			System.out.println("Phong ban: " + accArr3[i].department.name);
//			System.out.println("--------------------");
//			i++;
//		} while (i < accArr3.length);
		
		
		
//		Question 15
//		int i = 0;
//		do {
//			if (i % 2 == 0) {
//				System.out.print(i + " ");
//			}
//			i++;
//		} while (i <= 20);
	}
}
