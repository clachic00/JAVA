package ex;

public class MyMath {
	//더하기 기능의 메서드를 가지는 클래스
	// 정수형 데이터 두개를 전달받아
	// 두 수의 합을 연산하고 그 결과를 반환하는 메서드
	long add(long a, long b) {
		long result = a+b;
				
		return result;		
		
	}
	
	long multiplication(long c, long d) {
		long result = c*d;
		
		return result;
	}
	
	long division (long e, long f) {
		long result1 = e/f;
		System.out.println(result1);
		long result2 = e%f;
		System.out.println(result2);

		return result1;
		
	}
	
	long subtraction (long g, long h) {
		long result = g-h;
		return result;
	}
	
	
	
	
}
