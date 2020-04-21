package arrayPractice;

import java.util.Scanner;

public class MinMaxAgain {

	static int[] arrs;

	MinMaxAgain(int[] arr) {
		arrs = arr;
	}

	public static int MiniValue(int[] arr) {
		arrs = arr;
		int min = arrs[0];
		for (int i = 1; i < arrs.length; i++) {
			if (arrs[i] < min) {
				min = arrs[i];
			}
		}
		return min;
	}

	public static int MaxValue(int[] arr) {
		arrs = arr;
		int max = arrs[0];
		for (int i = 1; i < arrs.length; i++) {
			if (arrs[i] > max) {
				max = arrs[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		int num;

		int[] array = new int[(int) (Math.random() * 5) + 1];
		System.out.println("숫자를" + array.length + "개 입력해주세요");
		while (true) {

			System.out.println("숫자를 입력해주세요");
			num = sc.nextInt();
			array[i] = num;
			if (i == array.length - 1) {
				System.out.println(MaxValue(array));
				System.out.println(MiniValue(array));

				break;

			}

			i++;

		}

	}

}
