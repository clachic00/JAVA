package ex;

public class shortPi {

	public static void main(String[] args) {

		float pi = 3.141592f;
		float shortPi = (int) (pi * 1000) / 1000f;

		System.out.println(shortPi);

		shortPi = Math.round(pi * 1000) / 1000f;

		System.out.println(shortPi);

	}

}
