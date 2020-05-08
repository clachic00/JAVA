package store;

import java.util.Scanner;

import potionStore.PotionInven;

public class Store {

	Scanner sc = new Scanner(System.in);
	int num;
	int select;
	PotionInven potion = new PotionInven();
	
	
	public void store(Player p) {

		System.out.println("1.포션 2.장비"); // 3. 스킬

		int i = sc.nextInt();
		sc.nextLine();

		switch (i) {

		case 1:
			System.out.println("1. 작은 포션 -회복량 :30 [20G]");
			System.out.println("2. 중간 포션 -회복량 :60 [30G]");
			System.out.println("3. 큰 포션 -회복량 :150 [60G]");
			System.out.println("마을");
			
			
			 select = sc.nextInt();
			sc.nextLine();
			
			
			
			switch(select) {
			
			case 1 : 
				System.out.println("구매할 포션의 갯수를 선택해주세요");
				num = sc.nextInt();
				sc.nextLine();
				p.p(int i, int num);
				
				
				
				break;
			case 2 : 
				System.out.println("구매할 포션의 갯수를 선택해주세요");
				 num = sc.nextInt();
					sc.nextLine();

				 
				 
				 
				break;
			case 3 : 
				System.out.println("구매할 포션의 갯수를 선택해주세요");
				 num = sc.nextInt();
					sc.nextLine();

				 
				 
				 
				 
				break;
				
			case 4 : 
				System.out.println("마을로 돌아갑니다.");
				return;
			}
			
			
			
			
			
			
			
			
		
			
			
			
			
			
			break;

		case 2:

			break;
			
		default:
			
			return;

//		  case 3 :
//		  
//		  break;
		 

		}

	}

}
