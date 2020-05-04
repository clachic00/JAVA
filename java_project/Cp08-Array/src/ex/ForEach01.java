package ex;

public class ForEach01 {

	public static void main(String[] args) {
		
		int[][] arr={ {1, 2, 3, 4, 5}, {1,3,5,7 }};
		
		int sum = 0;
		for(int[] e: arr) {
			for(int f : e) {
			System.out.print(f);
			
			}
			System.out.println();
			}
		System.out.println(sum);
		
	}

}
