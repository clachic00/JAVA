
package method;
import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
	String name;
	int Math;
	
	System.out.println("이름?");
		name = sc.next();
		
	System.out.println("수학?");
		Math = sc.nextInt();
	System.out.println(name +":"+Math);
		
		
	}

}
