package potionStore;

import java.util.ArrayList;

public class PotionInven {

	ArrayList<Potion> potion = new ArrayList<Potion>(3);

	// S M L
	Potion sp = new Potion("Small Potion", 30, 0, 20);

	Potion np = new Potion("Normal Potion", 60, 0, 30);

	Potion bp = new Potion("Big Potion", 150, 0, 60);

	// 소지한 포션의 리스트 생성

	public PotionInven() {

	}

	public PotionInven(Object object, int i, int j, int k) {
	}

	// 포션구매 메서드
	public void buyPotion(int i, int num) {

		// 처음에만 포션틀을 추가
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}

		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) + num, 20));

			// 돈 증가 세터

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 60, (potion.get(1).pNum) + num, 30));

			// 돈 증가 세터

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 150, (potion.get(2).pNum) + num, 60));

			// 돈 증가 세터

			break;

		}

		System.out.println(potion.get(i - 1).pName + ", " + potion.get(i - 1).pNum);

		System.out.println(potion.toString());

	}

	// 포션 사용 메서드
	public void usePotion(int i, int num) {

		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) - num, 20));

			// 체력 증가 세터

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 50, (potion.get(1).pNum) - num, 30));

			// 체력 증가 세터

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 100, (potion.get(2).pNum) - num, 60));

			// 체력 증가 세터

			break;

		}

	}

	public void showPotion() {
		
		System.out.println(potion.toString());
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
