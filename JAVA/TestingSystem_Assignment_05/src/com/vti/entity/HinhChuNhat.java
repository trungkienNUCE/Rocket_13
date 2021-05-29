package com.vti.entity;

public class HinhChuNhat{
	private Float a;
	private Float b;

	public Float chuVi() {
		return 2 * (a + b);
	}

	public Float dienTich() {
		return a * b;
	}

	public HinhChuNhat(Float a, Float b) {
		super();
		this.a = a;
		this.b = b;
	}

}
