package com.vti.entity;

public class HighSchoolStudent extends Student1{
	private String clazz;
	private String desiredUniversity;
	
	public HighSchoolStudent( int id, String name, String clazz, String desiredUniversity) {
		super(id, name);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return super.toString() + "HighSchoolStudent [clazz=" + clazz + ", desiredUniversity=" + desiredUniversity + "]";
	}

	@Override
	public void nauCom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToSchool() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void thiCu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lamBai() {
		// TODO Auto-generated method stub
		
	}
	
	
}
