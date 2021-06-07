package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1;
import com.vti.backend.Exercise2;

public class Program1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Exercise1 ex1 = new Exercise1();
		ex1.question1();
//		ex1.question2();
//		ex1.question3();
//		ex1.question4();
//		ex1.question5();
		
		Exercise2 ex2 = new Exercise2();
		ex2.question1();
//		ex2.question2();
//		ex2.question3();
//		ex2.question4();
//		ex2.question5();
//		ex2.question6();
//		ex2.question7();
	}
}
