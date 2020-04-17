package ex;

public class addEx07_2 {

	public static void main(String[] args) {


		
		
		
		
		
		
		// Ex10

		int num = 12345;

		int sum2 = 0;
		int a = 0;
		while (true) {

			a = num % 10;
			num = num / 10;
			sum2 = sum2 + a;

			if (num < 10) {
				sum2 = sum2 + num;
				break;
			}

		}

		System.out.println("sum2=" + sum2);

	} // end of main

} // end of class
