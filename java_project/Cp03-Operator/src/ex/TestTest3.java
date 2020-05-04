package ex;

public class TestTest3 {

	public static void main(String[] args) {
		//2.
		int numOfApples =123; 

		int sizeOfBucket =10;
		
		int numOfBucket = numOfApples % sizeOfBucket >0 ?numOfApples/sizeOfBucket+1:numOfApples/sizeOfBucket; 
		
		System.out.println("필요한바구니의 수 :"+numOfBucket);
		
		//3.
		
		int num = 10;

		System.out.println( num>0 ? "양수": num<0 ? "음수" :0   );
		
		//4.
		
		int num2 = 111;
		
		System.out.println(num2 - num2%100);
		
		//5.
		
		int num3 = 777;

		System.out.println(num3- num3%110 +1);
		
		//6.
		
		int num4 = 24;

		System.out.println(10 - num4%10 );
		
		
		//7.
		
		int fahrenheit =100;

		float celcius =  (int)(5/9f*100000)*(fahrenheit -32) /100%10 > 5 ? (int)(5/9f*100000)*(fahrenheit -32) /1000 /100f +0.01f : (int)(5/9f*100000)*(fahrenheit -32) /1000 /100f ; 
		System.out.println("Fahrenheit:"+fahrenheit);

		System.out.println("Celcius:"+celcius);
		
		//8.
		char ch = 'A';

		ch += 2; 
		
		System.out.println(ch);
		
		
		long l = 3000l * 3000 * 3000;
		
		System.out.println(l);
		
		float f2 = 0.1f;

		double d = 0.1;

		boolean result = (float)d==f2;  
		
		System.out.println(result);
		
		//9.
		
		
		//유니코드 48~57 , 65~90, 97~122
		
		char ch2 = 'z';

		boolean b = ( 58 > ch2 && ch2>47 ||   91 > ch2 && ch2>64 || 123 > ch2 && ch2>96   );

		System.out.println(b);
		
		
		//10.
		
		char ch3 = 'A';

		char lowerCase = (char) (91 < ch3   ?  ch3 : ch3 >64  ? ch3+32 : ch3) ;

		System.out.println("ch:"+ch3);

		System.out.println("chto lowerCase:"+lowerCase);
		
		
		
		
		
	}

}
