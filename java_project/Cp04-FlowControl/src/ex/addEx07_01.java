package ex;

public class addEx07_01 {

	public static void main(String[] args) {

		// Ex9.

		String str = "12345";

		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 48;

			sum = sum + num;

		}

		System.out.println("sum=" + sum);

	} // end of main

} // end of class
