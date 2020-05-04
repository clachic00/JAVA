package ex;

public class addEx08 {

	public static void main(String[] args) {

		// Ex11.

		int a = 1;
		int b=1;
		int  c = 0;
		
		System.out.println(a+","+b);
		for (int i = 1; i <9; i++) {
			
			c = a+b;
			
		
			a=b;
			b=c;
			System.out.print(","+c );	
		}
	
		
		
		
		
		
		
	} // end of main

} // end of class
