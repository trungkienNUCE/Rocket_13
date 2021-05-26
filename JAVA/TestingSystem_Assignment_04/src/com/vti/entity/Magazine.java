package com.vti.entity;

import java.util.Date;

public class Magazine extends Doccument{
	private int idRelease;
	private String monthOfRelease;
	public Magazine(int id, String producer, int releaseNumber, int idRelease, String monthOfRelease) {
		super(id, producer, releaseNumber);
		this.idRelease = idRelease;
		this.monthOfRelease = monthOfRelease;
	}
	@Override
	public String toString() {
		return super.toString() + "Magazine [idRelease=" + idRelease + ", monthOfRelease=" + monthOfRelease + "]";
	}
	public int getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(int idRelease) {
		this.idRelease = idRelease;
	}
	public String getMonthOfRelease() {
		return monthOfRelease;
	}
	public void setMonthOfRelease(String monthOfRelease) {
		this.monthOfRelease = monthOfRelease;
	}
	
}
