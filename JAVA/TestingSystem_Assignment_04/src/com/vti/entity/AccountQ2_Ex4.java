package com.vti.entity;

public class AccountQ2_Ex4 {
	private String id;
	private String name;
	private int balance;

	public AccountQ2_Ex4(String string, String name, int balance) {
		super();
		this.id = string;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int credit(int amount) {
		return amount;
	}

	public int debit(int amount) {
		return amount;
	}

	public void tranferTo(AccountQ2_Ex4 accountq2_ex4, int amount) {
		this.balance -= amount;
		accountq2_ex4.balance += amount;
	}
}
