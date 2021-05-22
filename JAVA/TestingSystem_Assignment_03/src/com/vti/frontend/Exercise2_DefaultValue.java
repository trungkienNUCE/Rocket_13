package com.vti.frontend;
import java.time.LocalDate;
import java.time.LocalTime;

import com.vti.entity.Account;

public class Exercise2_DefaultValue {

	public static void main(String[] args) {
		question2();
	}

	private static void question2() {
		Account[] accounts = new Account[5];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account();
			accounts[i].email = "Email" + (i + 1);
			accounts[i].userName = "userName" + (i + 1);
			accounts[i].fullName = "fullName" + (i + 1);
			accounts[i].createDate = LocalDate.now();
		}

		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("Username: " + account.userName);
			System.out.println("Fullname: " + account.fullName);
			System.out.println("Creatdate: " + account.createDate);
			System.out.println("_______________");
		}		
	}

}
