package week;

import java.util.Scanner;

public class InterfaceMain  {

	public static void main(String[] args) {

		System.out.println("요일을 선택해주세요");
		System.out.println("1.월, 2.화, 3.수, 4.목, 5.금, 6.토, 7.일");

		Scanner sc = new Scanner(System.in);

		switch (sc.nextInt()) {

		case Week.mon:
			System.out.println("월요일 입니다");
			break;
		case Week.tues:
			System.out.println("화요일 입니다");

			break;

		case Week.wednes:
			System.out.println("수요일 입니다");

			break;
		case Week.thurs:
			System.out.println("목요일 입니다");

			break;

		case Week.fri:
			System.out.println("금요일 입니다");

			break;
		case Week.satur:
			System.out.println("토요일 입니다");

			break;

		case Week.sun:
			System.out.println("일요일 입니다");

			break;

		}

	}

}
