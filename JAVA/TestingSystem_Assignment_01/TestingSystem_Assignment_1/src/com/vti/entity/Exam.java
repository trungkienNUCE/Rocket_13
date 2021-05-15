package com.vti.entity;

import java.time.LocalDate;

public class Exam {
	public int id;
	public String code;
	public String title;
	public CategoryQuestion categoryId;
	public int duration;
	public Account  creatorId;
	public LocalDate createDate;
	public Question[] questions;
}
