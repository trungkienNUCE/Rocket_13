package com.vti.entity;

public class Position {
	public int id;
	public PositionName name;
	
//	dinh nghia ra kieu du lieu position co 4 gia tri
	public enum PositionName{
		DEV, TEST, SCRUM_MASTER, PM
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
	
	
}

