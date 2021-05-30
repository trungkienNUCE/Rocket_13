package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Position {
	public static int COUNT = 0;
	public int id;
	public PositionName posName;

	@Override
	public String toString() {
		return "Position [id=" + id + ", posName=" + posName + "]";
	}

	public Position() {
		super();
		COUNT++;
		this.id = COUNT;
		System.out.println("Chọn tên vị trí muốn nhập 1.Dev, 2.Test, 3.Scrum_Master, 4.PM : ");
		while (true) {
			int choosePos = ScannerUltis.inputIntPositive();
			switch (choosePos) {
			case 1:
				this.posName = PositionName.DEV;
				return;
			case 2:
				this.posName = PositionName.TEST;
				return;
			case 3:
				this.posName = PositionName.SCRUM_MASTER;
				return;
			case 4:
				this.posName = PositionName.PM;
				return;
			default:
				System.err.println("Chọn lại: ");

			}
		}
	}
}
