package com.vti.backend;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.vti.ultis.FileUltis;
import com.vti.ultis.ScannerUltis;

public class Ex3_File {

//	C:\\Users\\Admin\\Desktop\\demo.txt
	public void question1() {
		System.out.println("Nhập đường dẫn: ");
		String pathName = ScannerUltis.inputString();
		if (FileUltis.isFileExists(pathName)) {
			System.out.println(FileUltis.FILE_EXISTS);
		} else {
			System.out.println(FileUltis.FILE_NOT_EXISTS);
		}
	}

	public void question2() throws Exception {
		System.out.println("Nhập đường dẫn và tên file mới: ");
		String pathName = ScannerUltis.inputString();
		FileUltis.createNewFile(pathName);
	}

	public void question4() throws Exception {
		System.out.println("Nhập đường dẫn và tên file muốn xoá: ");
		String pathName = ScannerUltis.inputString();
		FileUltis.deleteFile(pathName);
	}

	public void question5() {
		System.out.println("Nhập đường dẫn: ");
		String pathname = ScannerUltis.inputString();
		FileUltis.isFolderOrFile(pathname);
	}

	public void question6() {
		System.out.println("Nhập đường dẫn: ");
		String path = ScannerUltis.inputString();
		String[] stringFile = FileUltis.getAllFileName(path);
		for (String listFile : stringFile) {
			System.out.println(listFile);
		}

	}

	public void question7() throws Exception {
		System.out.println("Nhập đường dẫn file cũ: ");
		String pathName1 = ScannerUltis.inputString();
		System.out.println("Nhập đường dẫn file mới (copy bản sao): ");
		String pathName2 = ScannerUltis.inputString();
		FileUltis.copyFile(pathName1, pathName2);
	}

	public void question8() throws Exception {
		System.out.println("Nhập đường dẫn file cũ: ");
		String pathName1 = ScannerUltis.inputString();
		System.out.println("Nhập đường dẫn file mới (move file cũ): ");
		String pathName2 = ScannerUltis.inputString();
		FileUltis.moveFile(pathName1, pathName2);
	}

	public void question9() throws Exception {
		System.out.println("Nhập đường dẫn file: ");
		String pathName1 = ScannerUltis.inputString();
		System.out.println("Nhập đường dẫn file mới (tên file mới): ");
		String pathName2 = ScannerUltis.inputString();
		FileUltis.renameFile(pathName1, pathName2);
	}

//	C:\\Users\\Admin\\Desktop\\demo.txt
	public void question10() throws Exception {
		System.out.println("Nhập đường dẫn folder tạo mới: ");
		String pathName = ScannerUltis.inputString();
		FileUltis.createNewFolder(pathName);
	}

	public void question11() throws Exception {
		System.out.println("Nhập đường link download: ");
		String fileLink = ScannerUltis.inputString();
		System.out.println("Nhập đường dẫn vị trí folder lưu: ");
		String pathFolder = ScannerUltis.inputString();
		FileUltis.downloadFile(fileLink, pathFolder);
	}

}
