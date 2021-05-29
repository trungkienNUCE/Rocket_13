package com.vti.entity;

public class DienThoaiThongMinh extends DienThoaiDiDong implements ITanCong{
	public void sd3G() {
		System.out.println("sử dụng 3G");
	}
	public void chupHinh() {
		System.out.println("chụp hinh");
	}
	@Override
	public void TanCong() {
		
	}
}
