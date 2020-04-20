package ex;

public class Method1 {

	public static void main(String[] args) {
		//메서드를 사용하기 위해서는 인스턴트 생성한후
		//메서드 코드를 메모리에 로드한다.
		
		//인스턴스 생성 (객체 생성)
		//1.
		MyMath mm = new MyMath();
		
		long value = mm.add(1L, 2L);
		
		System.out.println(value);
		System.out.println(mm.add(10000000000L, 20000000000L));
		long value7 = mm.division(50, 8);
		System.out.println(value7);
		
		
		//2.
		absoluteValue ab = new absoluteValue();
		int value2 = ab.Absolute(-150);
		
		System.out.println(value2);
		
		//3.
		
		circle cir = new circle();
		double value3 = cir.CircleArea(3);
		double value4 = cir.CircleRound(3);
		
		System.out.println(value3);
		System.out.println(value4);
		
		
		
		//4.
		
		primeNumber ac= new primeNumber();
		int n = 0;
		for (n=2;n<=100;n++) {
		boolean value5 = ac.PrimeNumber(n);
		if (value5==true) {
		System.out.println(n);}
		}
		
		
		
		
		
		
	}
	int add() {
		return 10;
	}

}
