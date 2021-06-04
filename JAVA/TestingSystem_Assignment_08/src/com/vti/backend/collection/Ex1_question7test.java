package com.vti.backend.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.vti.entity.Student7;
import com.vti.entity.Student;
import com.vti.entity.Student2;
import com.vti.ultis.ScannerUltis;

public class Ex1_question7test {
	Map<String, Student7> studentMap = new HashMap<>();

	public void question7() {
		System.out.println("Bạn muốn tạo bao nhiêu sinh viên: ");
		int sl = ScannerUltis.inputIntPositive();
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " là: ");
			String name = ScannerUltis.inputString();
			studentMap.put(name, new Student7(name));
		}
//		System.out.println("Sắp xếp thứ tự theo tên là: ");
//		for (Entry<String, Student6> stMap : studentMap.entrySet()) {
//			System.out.println(stMap.getValue());
//		}

		System.out.println("Sắp xếp thứ tự theo tên");
		TreeMap<String, Student7> sorted = new TreeMap<>(studentMap);
		sorted.putAll(studentMap);
		System.out.println(sorted);

	}

}
