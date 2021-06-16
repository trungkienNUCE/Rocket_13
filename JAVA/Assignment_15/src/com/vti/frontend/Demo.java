//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 14, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 14, 2021
 */
public class Demo {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Function function = new Function();
		while (true) {
			System.out.println("------MỜI BẠN LOGIN------");
			function.islogin();
		}
	}
}
