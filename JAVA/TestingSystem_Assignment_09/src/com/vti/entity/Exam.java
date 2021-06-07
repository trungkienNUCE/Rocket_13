package com.vti.entity;

import java.util.Date;

public class Exam {
	public int id;
	public String code;
	public String title;
 	public int duration;
	public Date createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Exam(int id, String code, String title, int duration, Date createDate) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.duration = duration;
		this.createDate = createDate;
	}
	
}
