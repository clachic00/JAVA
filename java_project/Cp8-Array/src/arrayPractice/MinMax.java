package arrayPractice;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax {

	static int[] arrs;

	MinMax(int[] arr) {
		arrs = arr;
	}

	public static int MiniValue(int[] arr) {

		arrs = arr;
		Arrays.sort(arrs);

		return arrs[0];

	}

	public static int MaxValue(int[] arr) {
		arrs = arr;
		Arrays.sort(arrs);
		int maxOfArr = arrs[arrs.length - 1];

		return maxOfArr;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		int num;

		System.out.println("추가할 숫자의 갯수를 입력해주세요");
		int[] array = new int[sc.nextInt()];
		while (true) {

			System.out.println("숫자를 입력해주세요");
			num = sc.nextInt();

			if (num == -1) {
				System.out.println(MaxValue(array));
				System.out.println(MiniValue(array));

				break;

			}

			array[i] = num;
			i++;

		}

	}

}
