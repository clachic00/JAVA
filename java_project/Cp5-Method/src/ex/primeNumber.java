package ex;

public class primeNumber {

	boolean PrimeNumber(int n) {
		boolean isprime = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isprime = false;
				break;
			}
		}

		if (isprime) {
			return true;

		} else {
			return false;
		}

	}
}
