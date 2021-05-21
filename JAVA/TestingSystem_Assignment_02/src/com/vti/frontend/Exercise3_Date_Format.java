package com.vti.frontend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.Exam;

public class Exercise3_Date_Format {
	public static void main(String[] args) {
		Exam exam01 = new Exam();
		exam01.id = 1;
		exam01.code = "VTI001";
		exam01.title = "De thi Java";
		exam01.duration = 90;
		exam01.createDate = LocalDate.of(2021, 5, 1);

		Exam exam02 = new Exam();
		exam02.id = 2;
		exam02.code = "VTI002";
		exam02.title = "De thi SQL";
		exam02.duration = 60;
		exam02.createDate = LocalDate.of(2021, 4, 1);

		Exam exam03 = new Exam();
		exam03.id = 3;
		exam03.code = "VTI003";
		exam03.title = "De thi PHP";
		exam03.duration = 120;
		exam03.createDate = LocalDate.of(2021, 1, 1);

//		Question 01
//		Locale locale = new Locale("vn", "VN");
//		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
//		String date = dateformat.format(exam01.createDate);
//		System.out.println(exam01.code + ": " + date);

//		Question 02
//		String pattern = "dd-MM-yyyy HH:mm:ss";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Exam[] exams = { exam01, exam02, exam03 };
//		for (Exam exam : exams) {
//			System.out.println("ID: " + exam.id + " " + "Code: " + " " +  exam.code + " " +  "Ngay tao:" + " " +  exam.createDate);
//		}

//		Question 03
//		String pattern = "yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Exam[] exams = { exam01, exam02, exam03 };
//		for (Exam exam : exams) {
//		String date = simpleDateFormat.format(exam.createDate);
//		System.out.println(exam.code + ": " + date);
//		}
		
//		Question 04 tuong tu cau 03
		
		
//		Question 05 tuong tu

	}
}
