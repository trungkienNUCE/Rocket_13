package com.vti.entity;

public class AccountQ2_Ex4 {
	private int id;
	private String name;
	private int balance;
	public AccountQ2_Ex4(int id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public int getId() {
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
		System.out.println("Tranfer " + accountq2_ex4 + " to " + accountq2_ex4.getName());
	}
	
}
