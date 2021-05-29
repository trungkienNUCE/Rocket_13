package com.vti.entity;

public class Contestant {
	public static int COUNT;
	private int idNum;
	private String name;
	private String address;
	private int priority;
	private Block block;

	public int getIdNum() {
		return idNum;
	}

	@Override
	public String toString() {
		return "Contestant [idNum=" + idNum + ", name=" + name + ", address=" + address + ", priority=" + priority
				+ ", block=" + block.getName() + ", subject =" + block.getSubject() + "]";
	}

	public Contestant(String name, String address, int priority, Block block) {
		COUNT++;
		this.idNum = COUNT;
		this.name = name;
		this.address = address;
		this.priority = priority;
		this.block = block;
	}

}
