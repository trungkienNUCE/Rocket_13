package com.vti.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.Exam;

public class Exercise01 {

	public void question1() {

		Exam ex01 = new Exam(1, "VTI1", "Java", 90, new Date("2020/08/09"));
		Exam ex02 = new Exam(2, "VTI2", "PHP", 90, new Date("2021/07/09"));
		Exam ex03 = new Exam(3, "VTI3", "SQL", 90, new Date("2019/06/09"));

//		Question 01
//		Locale locale = new Locale("vn", "VN");
//		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
//		System.out.println(ex01.code + ": " + dateFormat.format(ex01.createDate));

//	Question 02
//		String pattern = "dd-MM-yyyy HH:mm:ss";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Exam[] exams = { ex01, ex02, ex03 };
//		for (Exam exam : exams) {
//			System.out.println("ID: " + exam.id + " " + "Code: " + " " +  exam.code + " " +  "Ngay tao:" + " " +  exam.createDate);
//		}

//	Question 03
//		String pattern = "yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Exam[] exams = { ex01, ex02, ex03 };
//		for (Exam exam : exams) {
//		String date = simpleDateFormat.format(exam.createDate);
//		System.out.println(exam.code + ": " + date);
//		}

//	Question 04 tuong tu cau 03
//		String pattern = "MM-yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Exam[] exams = { ex01, ex02, ex03 };
//		for (Exam exam : exams) {
//		String date = simpleDateFormat.format(exam.createDate);
//		System.out.println(exam.code + ": " + date);
//		}
//	Question 05 tuong tu
		String pattern = "MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { ex01, ex02, ex03 };
		for (Exam exam : exams) {
			String date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}
}
