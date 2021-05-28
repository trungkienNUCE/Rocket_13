package com.vti.entity;

import java.util.Date;

public class NewSpaper extends Doccument {
	private String dayOfRelease;

	public NewSpaper(int id, String producer, int releaseNumber, String dayOfRelease2) {
		super(id, producer, releaseNumber);
		this.dayOfRelease = dayOfRelease2;
	}

	@Override
	public String toString() {
		return super.toString() + "Thể loại: Báo - Ngày phát hành: " + dayOfRelease + "]";
	}

	public String getDayOfRelease() {
		return dayOfRelease;
	}

	public void setDayOfRelease(String dayOfRelease) {
		this.dayOfRelease = dayOfRelease;
	}

}
