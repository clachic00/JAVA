package ex;

public class Test33 {

	public static void main(String[] args) {
		int fahrenheit =100;

		float celcius =  (int)(5/9f*100000)*(fahrenheit -32) /100%10 > 5 ? (int)(5/9f*100000)*(fahrenheit -32) /1000 /100f +0.01f : (int)(5/9f*100000)*(fahrenheit -32) /1000 /100f ; 
		System.out.println("Fahrenheit:"+fahrenheit);

		System.out.println("Celcius:"+celcius);
		
		
		

	}

}
