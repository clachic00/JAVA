package ex;

public class TestTest {

	public static void main(String[] args) {
		// 0.
		char c1 = 'a';
		char c2 = (char) (c1 + 1);
		char c3 = ++c1;
		int i = 'B' - 'A';
		int j = '2' - '0';

		// 1.
		int num1 = 10, num2 = 20, num3 = 30;

		num1 = num2 = num3;

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		// =는 뒤에서 앞으로 연산하므로 num3의 값이 num2에 대입되고 num2의 값이 num1에 대입된다
		
		// 2.
		int k = (((25 * 5) + (36 - 4)) - 72) / 5;

		System.out.println(k);

		// 3.
		int a = 3 + 6;
		int b = a + 9;
		int c = b + 12;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		// 4.

		int a4 = (((25 + 5) + (36 / 4)) - 72) * 5;
		int b4 = (((25 * 5) + (36 - 4)) - 71) / 4;
		int c4 = (128 / 4) * 2;

		boolean result = a4 > b4 && b4 > c4;

		if (result) {
			System.out.println("true");
		} else {
			System.out.println("fasle");
		}

	}

}
