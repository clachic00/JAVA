package ex;

public class LogicOp {

	public static void main(String[] args) {

		int num1 = 10, num2 = 20;
		// 사용자에게 받는 숫자들

		// num1이 num2보다 큰지 확인
		// 큰 경우 -> true, 작은경우 ->false

		boolean result1 = (num1 == 10 && num2 == 20);
		boolean result2 = (num1 <= 12 || num2 <= 30);

		System.out.println("num1++10 그리고 num2==20: " + result1);
		System.out.println("num1<=12 또는 num2<=30: " + result2);

		if (!(num1 == num2)) {
			System.out.println("num1과 num2는 같지 않다");

		} else {
			System.out.println("num1과 num2는 같다");
		}

//		
//		성인
//		여성
//		기혼자
//		에게만 메세지를 보내기

		System.out.println("--------------");

		int age = 20;
		char gender = 'w';
		boolean mCheck = true;

		boolean result = age >= 20 && gender == 'w' && mCheck == true;

		if (result) {
			System.out.println("멧지를 보냅니다.");
		}

	}

}
