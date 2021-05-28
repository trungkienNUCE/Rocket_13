package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;

public class Exersice1_Abstraction {
	Scanner scanner = new Scanner(System.in);
	ArrayList<News> newsList = new ArrayList<News>();

	public void question1() {
		menuQues1();
	}

	private void menuQues1() {
		int choose;
		while (true) {
			System.out.format("%n+-------------------------------------------------+%n");
			System.out.println("=> Mời bạn chọn chức năng muốn sử dụng");
			String leftAlign = "| %-46s  |%n";
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		 Nhập chức năng			  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format(leftAlign, "1. Insert news");
			System.out.format(leftAlign, "2. View list newsu");
			System.out.format(leftAlign, "3. Average rate");
			System.out.format(leftAlign, "4. Exit           ");
			System.out.format("+-------------------------------------------------+%n");
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				addNews();
				break;
			case 2:
				viewListNews();
				break;
			case 3:
				averageRate();
				break;
			case 4:
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1 - để tiếp tục, Nhập bất kỳ để thoát");
				String tt1 = scanner.next();
				if (tt1.equals("1")) {
					System.out.println("Nhập lại chức năng");
					break;
				} else {
					System.out.println("Good Bye!");
					return;
				}
			default:
				System.out.println("Nhập lại");
				break;
			}
		}

	}

	public void averageRate() {
		for (News news : newsList) {
			System.out.println("Title: " + news.getTitle() + "  - Average Rate: " + news.calculate());
			System.out.println("Thông tin chi tiết: ");
			news.display();
			System.out.println("----------------");
		}

	}

	public void viewListNews() {
		for (News news : newsList) {
			System.out.println("Thông tin chi tiết: ");
			news.display();
			System.out.println("------------------");
		}

	}

	public void addNews() {
		News news = new News();
		int[] rates = new int[3];

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập Title: ");
		news.setTitle(scanner.nextLine());

		System.out.println("Nhập Publish Date: ");
		news.setPublishDate(scanner.nextLine());

		System.out.println("Nhập Author: ");
		news.setAuthor(scanner.nextLine());

		System.out.println("Nhập Content: ");
		news.setContent(scanner.nextLine());

		System.out.println("Nhập 3 đánh giá: ");
		for (int i = 0; i < 3; i++) {
			System.out.println("Đánh giá " + (i + 1) + ": ");
			rates[i] = scanner.nextInt();
		}
		news.setRates(rates);

		newsList.add(news);
	}
}
