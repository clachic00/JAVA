package ex;

public class addEx7 {

	public static void main(String[] args) {

		// Ex9.

		// Ex10

		int num = 12345;

		int sum = 0;
		int a = 0;
		while (true) {

			a = num % 10;
			num = num / 10;
			sum = sum + a;

			if (num < 10) {
				sum = sum + num;
				break;
			}

		}

		System.out.println("sum=" + sum);

	} // end of main

} // end of class
