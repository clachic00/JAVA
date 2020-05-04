package ex;

import java.util.Scanner;

public class addEx09 {

	public static void main(String[] args) {

		
		// Ex13.
		
		
		String value = "12o34";

		char ch = ' ';

		boolean isNumber = true;

		// 반복문과 charAt(inti)를 이용해서 문자열의 문자를

		// 하나씩 읽어서 검사한다.

		for(int i=0; i < value.length() ;i++) {

			int a = value.charAt(i);
			
			isNumber = (a<='9'&&a>='0');
		
			if (isNumber==false) {
				break;
			}
		
			
			
		}

		if (isNumber) {

		System.out.println(value+"는 숫자입니다.");

		} else {

		System.out.println(value+"는 숫자가 아닙니다.");

		}
		
		
	
				
				
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
			System.out.println("UP");
		} else if (input == answer) {
			System.out.println("찾았습니다");
			System.out.println("시도횟수 : "+count+ "번입니다.");
			break;
		}else {
			System.out.println("DOWN");
		}
		
		} while(true); // 무한반복문

		
		
	} // end of main

} // end of class
