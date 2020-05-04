package scannerPractice;
import java.util.Scanner;
public class question {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 이름은?");
		String str = sc.nextLine();
		System.out.println("안녕하세요 "+str+"님");
		System.out.println("당신은 치킨을 좋아한다는데, 진실입니까");
		boolean isTrue = sc.nextBoolean();
		if(isTrue ==true) {
			System.out.println("오 역시 좋아하시는군요");
		} else {
			System.out.println("치킨을 싫어하다니");
		}
	
		System.out.println("당신과 동생의 키는 어떻게 되나요?");
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		double diff = num1 - num2;
		if(diff>0)
			System.out.println("당신이 "+diff+"만큼 크군요.");
			else
			System.out.println("당신이 "+(-diff)+"만큼 작군요.");
	}

}
