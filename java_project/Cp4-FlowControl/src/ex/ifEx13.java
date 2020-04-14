package ex;

public class ifEx13 {

	public static void main(String[] args) {

	//12.
		
		int i = 1;
		int sum = 0;
		while (true) {
			if (i%2==1||i%6==0) {
				sum = sum + i;
			}
			if (sum>1000) {
				break;
			}
			i++;
		}
		System.out.println(sum);
		
		
	
			
		
	}

}
