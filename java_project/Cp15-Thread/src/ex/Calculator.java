package ex;

public class Calculator {

	int opCnt = 0;

	synchronized int add(int n1, int n2) {

		System.out.println("덧셈 연산");

		synchronized (this) {
			opCnt++;
		}

		return n1 + n2;

	}

	int min(int n1, int n2) {
		System.out.println("뺄셈 연산");
		synchronized (this) {
			opCnt++;
		}

		return n1 - n2;

	}

	void showOpCnt() {
		System.out.println("연산의 횟수는 " + opCnt + "입니다.");
	}

}
