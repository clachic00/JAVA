package ex;

public class addEx8 {

	public static void main(String[] args) {

		// Ex11.

		int a = 1;
		int b=1;
		int  c = 0;
		
		System.out.println(a);
		for (int i = 1; i <9; i++) {
			
			c = a+b;
			
			System.out.println(b);
			a=b;
			b=c;
			
		}
		System.out.println(c);
		
		
		
		
		
		
	} // end of main

} // end of class
