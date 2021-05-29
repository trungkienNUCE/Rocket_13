package com.vti.entity;

public class Block {
	private String name;
	private String subject;
	public Block(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		switch (this.name) {
		case "A":
			this.subject = "Toan, Ly, Hoa";
			break;
		case "B":
			this.subject = "Toan, Hoa, SInh";
			break;
		case "C":
			this.subject = "Van, Su, Dia";
			break;
		default:
			break;
		}
		return subject;
	}
	@Override
	public String toString() {
		return "Block [name=" + name + ", subject=" + subject + "]";
	}
	
}
