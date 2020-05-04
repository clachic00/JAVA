package phonenumber;

import java.util.Scanner;

public class phoneUi {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String num = "";
		String n ="";
		String birth ="";
		
		int out = 0;
		int a = 0;
		int b = 0;

		while(true) {
			
		System.out.println("이름입력");
		
		n=sc.next();
	
		System.out.println("번호입력");

		num=sc.next();
		
		System.out.println("생일입력");
	
		birth=sc.next();
		MachineOfPhoneNumber inf = new MachineOfPhoneNumber(n,num,birth);

		inf.Save(inf);
		
		System.out.println("계속하려면 1 멈추려면0입력 ");
		
		out=sc.nextInt();
		
		if (out == 0) {
			while (true) {
			System.out.println("궁금한 숫자 입력");
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(inf.ShowInfor(a, b));
	
			System.out.println("계속하려면 1 멈추려면0입력 ");
			
			int out1=sc.nextInt();
			if(out1==0) {
				break;
			} else if(out==1) {
				continue;
			}
			}
			break;
			
			
			} else if(out == 1){
				continue;
			}
		
	
		
	
		
		}

		
		

		
		
		
		
		
		
	}

}
