package com.vti.backend.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.vti.entity.Student;
import com.vti.entity.Student2;
import com.vti.ultis.ScannerUltis;

public class Ex1_question6{
	Map<Integer, String> studentMap = new HashMap<Integer, String>();
	private String name;
	
	public void question6() {
		System.out.println("Bạn muốn tạo bao nhiêu sinh viên: ");
		int sl = ScannerUltis.inputIntPositive();
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " là: ");
			name = ScannerUltis.inputString();
			studentMap.put(i + 1, name);
		}
		System.out.println("Danh sách sinh viên là: ");
		for (Map.Entry<Integer, String> stMap : studentMap.entrySet()) {
			System.out.println("Id: " + stMap.getKey() + " Tên: " + stMap.getValue());
		}
	}

	public void question7() {
		System.out.println("Danh sách các key là (key - id): ");
		for (Map.Entry<Integer, String> stMap : studentMap.entrySet()) {
			System.out.println(stMap.getKey());
		}

		System.out.println("Danh sách các value là (value - tên): ");
		for (Map.Entry<Integer, String> stMap : studentMap.entrySet()) {
			System.out.println(stMap.getValue());
		}
		
		System.out.println("Sắp xếp thứ tự theo tên");
		TreeMap<Integer, String> sorted = new TreeMap<>(studentMap);
		sorted.putAll(studentMap);
		System.out.println(sorted);

	}
}
