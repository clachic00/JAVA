package ex;

public class DivideByZero {

	public static void main(String[] args) {

	int num1 = 1;
	int num2 = 0;

	try {
	int divide = num1/num2;
	System.out.println(divide);
	} catch(ArithmeticException e) {
		System.out.println("0으로 나눌 수 없습니다");
		System.out.println(e.getMessage());
//		e.printStackTrace();
	}
	
	System.out.println("프로그램을 종료합니다");

	
	
	}

}
