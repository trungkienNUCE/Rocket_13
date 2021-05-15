package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;

public class TestingSystem_Assignment_01 {
	public static void main(String[] args) {

//  QUESTION 2: KHOI TAO 3 DOI TUONG O MOI CLASS
//	tao department
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

//		tao position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.SCRUM_MASTER;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.TEST;

//		tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";
//		group1.creatorId = 2;
		group1.createDate = LocalDate.of(2020, 8, 1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2020, 3, 1);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Testing System";
		group3.createDate = LocalDate.of(2020, 1, 1);

//		tao account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "trantrungkien@gmail.com";
		acc1.userName = "trungkien";
		acc1.fullName = "Tran Trung Kien";
		acc1.position = pos2;
		acc1.createDate = LocalDate.of(2011, 8, 9);
		Group[] groupAcc1 = { group1, group2 };
		Department[] depAcc1 = { dep1, dep2 };
		acc1.groups = groupAcc1;
		acc1.departments = depAcc1;

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "account02@gmail.com";
		acc2.userName = "account02";
		acc2.fullName = "Full Name 03";
		acc2.position = pos1;
		acc2.createDate = LocalDate.of(2020, 12, 20);
		Group[] groupAcc2 = { group1, group3 };
		Department[] depAcc2 = { dep1 };
		acc2.groups = groupAcc2;
		acc2.departments = depAcc2;

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "account03@gmail.com";
		acc3.userName = "account03";
		acc3.fullName = "Full Name 03";
		acc3.position = pos1;
		acc3.createDate = LocalDate.now();
		Group[] groupAcc3 = { group2 };
		Department[] depAcc3 = { dep2 };
		acc3.groups = groupAcc3;
		acc3.departments = depAcc3;

//		tao GroupAccount
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

//		tao TypeQuestion
		TypeQuestion typequestion1 = new TypeQuestion();
		typequestion1.id = 1;
		typequestion1.name = TypeName.ESSAY;

		TypeQuestion typequestion2 = new TypeQuestion();
		typequestion2.id = 2;
		typequestion2.name = TypeName.MULATIPLE_CHOICE;

//		Tao CategoryQuestion
		CategoryQuestion catequestion01 = new CategoryQuestion();
		catequestion01.id = 1;
		catequestion01.name = "Java";

		CategoryQuestion catequestion02 = new CategoryQuestion();
		catequestion02.id = 2;
		catequestion02.name = "SQL";

		CategoryQuestion catequestion03 = new CategoryQuestion();
		catequestion03.id = 3;
		catequestion03.name = "PHP";

//		Tao Question
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

//		Tao Answer
		Answer answer01 = new Answer();
		answer01.id = 1;
		answer01.content = "Hoc Java trong 1 nam";
		answer01.questionId = question01;
//		answer01.isCorrect = 

		Answer answer02 = new Answer();
		answer02.id = 2;
		answer02.content = "Hoc Java trong 4.5 thang";
		answer02.questionId = question01;

		Answer answer03 = new Answer();
		answer03.id = 3;
		answer03.content = "SQL la ngon ngu truy van co cau truc";
		answer03.questionId = question03;

//		tao Exam
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

//		tao ExamQuestion
		ExamQuestion examquestion01 = new ExamQuestion();
		examquestion01.examId = exam01;
		examquestion01.questionId = question02;

		ExamQuestion examquestion02 = new ExamQuestion();
		examquestion02.examId = exam02;
		examquestion02.questionId = question01;

//  QUESTION 3: IN 1 DOI TUONG RA MAN HINH
		System.out.println("Thong tin ACCOUNT 01");
		System.out.println("ID: " + acc1.id);
		System.out.println("Email: " + acc1.email);
		System.out.println("Username: " + acc1.userName);
		System.out.println("Fullname: " + acc1.fullName);
		System.out.println("Group: " + acc1.groups[0].name + ", " + acc1.groups[1].name);
		System.out.println("Department: " + acc1.departments[0].name + ", " + acc1.departments[1].name);
		System.out.println("CreateDate: " + acc1.createDate);

		System.out.println("_____________________");

		System.out.println("In thong tin GROUP 01");
		System.out.println("ID: " + group1.id);
		System.out.println("Groupname: " + group1.name);
		System.out.println("CreateDate: " + group1.createDate);

		System.out.println("_____________________");

		System.out.println("In thong tin DEPARTMENT 01");
		System.out.println("ID: " + dep1.id);
		System.out.println("Groupname: " + dep1.name);

		System.out.println("_____________________");

		System.out.println("In thong tin POSITION 02");
		System.out.println("ID: " + pos2.id);
		System.out.println("Groupname: " + pos2.name);

		System.out.println("_____________________");

		System.out.println("In thong tin GROUPACCOUNT 01");
		System.out.println("ID: " + groupaccount1.id);
		System.out.println("AccounId: " + groupaccount1.accountId);
		System.out.println("Ngay tham gia: " + groupaccount1.joinDate);

		System.out.println("_____________________");

		System.out.println("In thong tin TYPEQUESTION");
		System.out.println("ID: " + typequestion1.id);
		System.out.println("Name: " + typequestion1.name);

		System.out.println("ID: " + typequestion2.id);
		System.out.println("Name: " + typequestion2.name);

		System.out.println("_____________________");

		System.out.println("In thong tin CATEGORYQUESTION");
		System.out.println("ID: " + catequestion01.id);
		System.out.println("Name: " + catequestion01.name);
		
		System.out.println("_____________________");

		System.out.println("In thong tin QUESTION");
		System.out.println("ID: " + question01.id);
		System.out.println("Content: " + question01.content);
		System.out.println("CategoryID: " + question01.categoryId);
		System.out.println("TypeID: " + question01.typeId);
		System.out.println("Nguoi tao: " + question01.accountId);
		System.out.println("Ngay tao: " + question01.createDate);
		
		System.out.println("_____________________");

		System.out.println("In thong tin ANSWER");
		System.out.println("ID: " + answer01.id);
		System.out.println("Content: " + answer01.content);
		System.out.println("QuestionId: " + answer01.questionId);
		
		System.out.println("_____________________");

		System.out.println("In thong tin EXAM");
		System.out.println("ID: " + exam01.id);
		System.out.println("Code: " + exam01.code);
		System.out.println("Title: " + exam01.title);
		System.out.println("CategoryId: " + exam01.categoryId);
		System.out.println("Duration: " + exam01.duration);
		System.out.println("CreateId: " + exam01.creatorId);
		System.out.println("Ngay tao: " + exam01.createDate);
		
		System.out.println("_____________________");

		System.out.println("In thong tin EXAMQUESTION");
		System.out.println("ID: " + examquestion01.examId);
		System.out.println("QuestionId: " + examquestion01.questionId);
	}
}
