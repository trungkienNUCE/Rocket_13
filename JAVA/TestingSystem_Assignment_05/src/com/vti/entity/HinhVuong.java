package com.vti.entity;

public class HinhVuong extends HinhChuNhat{
	private float a;
	public HinhVuong(Float a) {
		super(a, a);
		// TODO Auto-generated constructor stub
	}

	public Float chuVi() {
		return a * 4;
	}

	public Float dienTich() {
		return a * a;
	}

	

}
