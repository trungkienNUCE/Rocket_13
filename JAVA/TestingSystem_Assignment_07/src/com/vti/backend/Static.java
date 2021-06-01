package com.vti.backend;

import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Static {

	private Student[] students;

	public void question1() throws Exception {
		students = new Student[3];
		students[0] = new Student("Nguyễn Văn A");
		students[1] = new Student("Nguyễn Văn B");
		students[2] = new Student("Nguyễn Văn C");

		for (Student student : students) {
			System.out.println(student);
		}

		// Thay đổi thành đại học công nghệ
		System.out.println("Chuyển sang ĐH Công Nghệ");
		Student.college = "Đại học công nghệ";

		for (Student student : students) {
			System.out.println(student);
		}

	}

	public void question2() {
		// Question2
		System.out.println("Mỗi bạn đóng 100k, tổng quỹ là: " + Student.moneyGroup);

		System.out.println("St1 lấy 20k mua đồ");
		System.out.println("Quỹ còn: " + (Student.moneyGroup -= 20));

		System.out.println("St2 lấy 70k mua đồ");
		System.out.println("Quỹ còn: " + (Student.moneyGroup -= 70));

		// cả nhóm mỗi người lại đóng quỹ mỗi người 50k
		for (Student student : students) {
			student.fund();
		}

		System.out.println("Số tiền sau khi mỗi sinh viên đóng thêm 50k là: ");
		System.out.println("Quỹ mới là: " + Student.moneyGroup);
	}

	public void question3() {
		System.out.println(MyMath.max(6, 9));
		System.out.println(MyMath.min(6, 9));
		System.out.println(MyMath.sum(6, 9));
		System.out.println(MyMath.sub(6, 9));
	}

	public void question4() {
		System.out.println("Chuyến sang ĐH Hà Nội");
		Student.changecollege("Đại Học Hà Nội");
//		Student.college = "ĐH HN";

		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void question5() {
		System.out.print("Số sinh viên được tạo: ");
		System.out.println(Student.counter);
	}

	public void question6() throws Exception {
		Student student1 = new PrimaryStudent("Nguyễn Văn A");
		Student student2 = new PrimaryStudent("Nguyễn Văn B");
		Student student3 = new SecondaryStudent("Nguyễn Văn C");
		Student student4 = new SecondaryStudent("Nguyễn Văn D");
		Student student5 = new SecondaryStudent("Nguyễn Văn E");
		Student student6 = new SecondaryStudent("Nguyễn Văn F");

		System.out.println("Couter of Student: " + Student.counter);
		System.out.println("Couter of Primary Student: " + PrimaryStudent.counterPrimary);
		System.out.println("Couter of Secondary Student: " + SecondaryStudent.counterSecondary);
	}

	public void question7() throws Exception {
		Student student1 = new PrimaryStudent("Nguyễn Văn A");
		Student student2 = new PrimaryStudent("Nguyễn Văn B");
		Student student3 = new SecondaryStudent("Nguyễn Văn C");
		Student student4 = new SecondaryStudent("Nguyễn Văn D");
		Student student5 = new SecondaryStudent("Nguyễn Văn E");
		Student student6 = new SecondaryStudent("Nguyễn Văn F");
		Student student7 = new SecondaryStudent("Nguyễn Văn G");
		Student student8 = new SecondaryStudent("Nguyễn Văn H");
		Student student9 = new SecondaryStudent("Nguyễn Văn I");
	}

}
