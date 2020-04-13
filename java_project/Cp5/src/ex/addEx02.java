package ex;

public class addEx02 {

	public static void main(String[] args) {

		// ex2
		int sum = 0;
		int n = 0;
		for (n = 0; n <= 20; n++) {
			if (!(n % 2 == 0 || n % 3 == 0)) {
				sum = sum + n;
			}
		}
		System.out.println(sum);

		// ex3

		int a = 0;
		int b = 0;
		int c = 0;

		for (a = 1; a <= 10; a++) {
			b = b + a;
			c = c + b;

		}
		System.out.println(c);

		// ex4

		int a2=0;
		int sum2 = 0;
		
		while (true) {
			a2++;
			if(a2%2==0) {
				a2 = a2 *-1;
			}
			sum=sum+a2;
			if (sum>=100) {
				break;
		
			}
			System.out.println(sum);
		}
		
		
		
		
		
		
		
	}

}
