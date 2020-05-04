package ex;

public class addEx06 {

	public static void main(String[] args) {

		// Ex8.

		int x = 0;
		int y = 0;
		for (x = 0; x <= 10; x++) {
			for (y = 0; y <= 10; y++) {
				int a = 2 * x + 4 * y;
				if (a == 10) {
					System.out.println("x:" + x + "y:" + y);
				}

			}
		}

	} // end of main

} // end of class
