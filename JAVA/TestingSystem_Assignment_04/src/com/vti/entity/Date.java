package com.vti.entity;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

	public boolean isLeapYear() {
//		ĐIỀU KIỆN NĂM NHUẬN LÀ NĂM CHIA HẾT CHO 100 VÀ CHIA HẾT CHO 4
		return getYear() % 100 == 0 && getYear() % 4 == 0 ? true : false;

		
//		if (getYear() % 100 == 0) {
//			if (getYear() % 400 == 0) {
//				System.out.println(" la nam nhuan");
//			} else {
//				System.out.println(" khong phai la nam nhuan");
//			}
//		} else if (getYear() % 4 == 0) {
//			System.out.println(" la nam nhuan");
//		} else {
//			System.out.println(" khong phai la nam nhuan");
//		}
	}

}
