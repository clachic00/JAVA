package ex;

import java.util.Scanner;

public class addEx9 {

	public static void main(String[] args) {

		
		// Ex13.
		
		
		//Ex14.
		
		int answer = (int)(Math.random()*100)+1;

		int input = 0; // 사용자입력을 저장할 공간

		int count = 0; // 시도횟수를 세기위한 변수

		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용

		java.util.Scanner s = new java.util.Scanner(System.in);

		do {

		count++;

		System.out.print("1과 100사이의 값을 입력하세요 :");

		input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.

		if (input<answer) {
			System.out.println("작습니다");
		} else if (input == answer) {
			System.out.println("정답입니다");
			System.out.println("시도횟수는 "+count+ "번입니다.");
			break;
		}else {
			System.out.println("큽니다");
		}
		
		} while(true); // 무한반복문

		
		
	} // end of main

} // end of class
