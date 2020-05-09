package store;

import java.util.Scanner;

import playerPart.Player;
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
			System.out.println("0. 마을로 돌아가기");

			select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				System.out.println("마을로 돌아갑니다.");
				return;
			}

			System.out.println("구매할 포션의 개수를 입력해주세요");
			num = sc.nextInt();
			sc.nextLine();

			p.buyPotion(select, num);

			break;

		case 2:

			System.out.println("구매할 장비를 골라주세요");
			int select = sc.nextInt();
			sc.nextLine();

			p.buyEquipment(select);

			break;

//		  case 3 :
//		  
//		  break;

		}

	}

}
