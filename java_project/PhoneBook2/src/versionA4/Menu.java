package versionA4;

import java.util.Scanner;

public class Menu {
	public static void menu() {
		System.out.println("========================");
		System.out.println("1.저장");
		System.out.println("2.검색");
		System.out.println("3.삭제");
		System.out.println("4.리스트");
		System.out.println("5.종료");
		System.out.println("========================");

	}

	public static int selectFriend() {
		Scanner sc = new Scanner(System.in);

		System.out.println("========================");
		System.out.println("1.일반 친구");
		System.out.println("2.학교 친구");
		System.out.println("3.회사 친구");
		System.out.println("========================");

		int select = sc.nextInt();

		return select;

	}

}
