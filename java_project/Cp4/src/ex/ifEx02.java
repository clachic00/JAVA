package ex;

public class ifEx02 {

	public static void main(String[] args) {
		
		int num = 250;
		if (num <0) {
			System.out.println("0 미만");
		} else if(0 <= num&&num <100) {
			System.out.println("0이상 100 미만");
		} else if(100 <= num&&num < 200) {
			System.out.println("100이상 200 미만");
		} else if(200 <= num&&num < 300) {
			System.out.println("200이상 300 미만");
		} else {System.out.println("300이상");
		}
		
		
	}	
		
	
}
