//
package com.vti.entity;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrungKienTran
 * @create_date: Jun 14, 2021
 * @version: 1.0
 * @modifer: TrungKienTran
 * @modifer_date: Jun 14, 2021
 */
public class Employee {
	private int id;
	private ProSkill proSkill;

	public enum ProSkill {
		DEV, TEST, JAVA, SQL
	}
}
