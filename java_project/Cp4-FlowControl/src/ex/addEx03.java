package ex;

public class addEx03 {

	public static void main(String[] args) {

		// Ex5.
		
//		for(int i=0; i<=10; i++) {
//
//			for(int j=0; j<=i; j++) 
//
//			System.out.print("*");
//
//			System.out.println();
//			
//			}


		int i = 0;
		int j = 0;
		while (i <= 10) {
		
		
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			i++;
			j=0;

			System.out.println();
		
		
		}

	} // end of main

} // end of class






