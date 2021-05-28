package com.vti.entity;

public class Doccument {
//	Mã tài liệu(Mã tài liệu là duy nhất),
//	Tên nhà xuất bản, số bản phát hành.
	private int id;
	private String producer;
	private int releaseNumber;
	public Doccument(int id, String producer, int releaseNumber) {
		super();
		this.id = id;
		this.producer = producer;
		this.releaseNumber = releaseNumber;
	}
	@Override
	public String toString() {
		return "Tài liệu [Mã tài liệu: " + id + ", Nhà sản xuất=" + producer + ", Số phát hành: " + releaseNumber + ", ";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getReleaseNumber() {
		return releaseNumber;
	}
	public void setReleaseNumber(int releaseNumber) {
		this.releaseNumber = releaseNumber;
	}
	
	
}
