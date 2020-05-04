package arrayPractice;

public class AddArray {

	void addOneDArr(int[][] arr, int add) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] += add;

			}

		}

		for (int[] e : arr) {
			for (int f : e) {
				System.out.println(f);
			}
		}

//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
//		System.out.println(arr[1][0]);
//		System.out.println(arr[1][1]);
//		System.out.println(arr[1][2]);

	}

	public static void main(String[] args) {

		int[][] tarray = new int[2][3];

		tarray[0][0] = 1;
		tarray[0][1] = 2;
		tarray[0][2] = 3;
		tarray[1][0] = 4;
		tarray[1][1] = 5;
		tarray[1][2] = 6;

		AddArray add = new AddArray();

		add.addOneDArr(tarray, 7);

	}

}
