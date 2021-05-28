package com.vti.entity;

public class Book extends Doccument{
	private String author;
	private int numberOfPage;
	
	public Book(int id, String producer, int releaseNumber, String author, int numberOfPage) {
		super(id, producer, releaseNumber);
		this.author = author;
		this.numberOfPage = numberOfPage;
	}

	@Override
	public String toString() {
		return super.toString() + "Thể loại: Sách - Tác giả: " + author + ", Số trang: " + numberOfPage + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	
	
}
