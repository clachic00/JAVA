package ex;

public class ifEx06 {

	public static void main(String[] args) {

		// 5.

		int num = 299, nums = 0;

		if (num < 0) {
			nums = 1;
		} else if (0 <= num && num < 100) {
			nums = 2;
		} else if (100 <= num && num < 200) {
			nums = 3;
		} else if (200 <= num && num < 300) {
			nums = 4;
		} else if (300 <= num) {
			nums = 5;
		}

		switch (nums) {
		case 1:
			System.out.println("0 미만");
			break;
		case 2:
			System.out.println("0이상 100 미만");
			break;
		case 3:
			System.out.println("100이상 200 미만“");
			break;
		case 4:
			System.out.println("200이상 300 미만");
			break;
		default:
			System.out.println("300이상");
		}

	}

}
