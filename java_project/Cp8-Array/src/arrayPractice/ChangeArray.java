package arrayPractice;

public class ChangeArray {

	int[][] array(int arr[][]) {

		int[] ext = arr[arr.length-1];
		for (int i = arr.length-1; i > 0; i--) {

			
			arr[i] = arr[i - 1];
			
			
		}
		arr[0] = ext;
		return arr;
	}

	public static void main(String[] args) {

		int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {10,11,12} };

		ChangeArray ca = new ChangeArray();

		ca.array(arr);

		
		for(int[] e: arr) {
		for(int f: e) {
			System.out.print(f+" ");
		}
		System.out.println();
		}
		
		
	}

}
