package ex;

import java.util.Random;
import java.util.StringTokenizer;

public class RandomNumber {

	public static void main(String[] args) {

		Random rand = new Random();
		
		for(int i =0; i<10; i++) {
			System.out.println("=================");
			System.out.println(rand.nextBoolean());
			System.out.println(rand.nextInt());
			System.out.println(rand.nextInt(45)+1);
		
			
		
		
		
		}
		
		
		

		
		
		String strData = "11:22:33:44:55";
		StringTokenizer st = new StringTokenizer(strData, ":");
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());

	
		
		
		
		
		
		
		
	}

}
