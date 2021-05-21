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

//		Exam[] exams = {exam01, exam02, exam03};
//		for (Exam exam : exams) {
//			System.out.println(exam.id + exam.code + exam.title);
//		}
//		
//		System.out.println(exam01.createDate);
//		
//		String date1 = new String();
//		
//		String pattern = "dd-MM-yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		
//		String date = simpleDateFormat.format(exam01.createDate);
//		System.out.println(date);

//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		String date2 = (String) exam01.createDate;
//
//		String dateFormat = formatter.format(date2);
//		System.out.println("Ngày đã được định dạng : " + dateFormat);

	}
}
