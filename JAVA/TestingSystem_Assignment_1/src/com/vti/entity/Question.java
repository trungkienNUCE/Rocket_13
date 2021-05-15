package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public int id;
	public String content;
	public CategoryQuestion categoryId;
	public TypeQuestion typeId;
	public Account accountId;
	public LocalDate createDate;
}
