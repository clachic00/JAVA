package PotionStore;

import java.util.ArrayList;

public class PotionInven {

	ArrayList<Potion> potion = new ArrayList<Potion>(3);

	// S M L
	Potion sp = new Potion("Small Potion", 30, 0);

	Potion np = new Potion("Normal Potion", 50, 0);

	Potion bp = new Potion("Big Potion", 100, 0);

	// 소지한 포션의 리스트 생성

	public PotionInven() {

	}

	public PotionInven(Object object, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	//포션구매 메서드
	public void buyPotion(int i, int num) {

		//처음에만 포션틀을 추가
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}

		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) + num));

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 50, (potion.get(1).pNum) + num));

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 100, (potion.get(2).pNum) + num));

			break;

		}

		System.out.println(potion.get(i - 1).pName + ", " + potion.get(i - 1).pNum);

		System.out.println(potion.toString());

	}
	
	
	//포션 사용 메서드
	public void usePotion(int i, int num) {
	
		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) - num));

			
			//체력 증가 세터 
			
			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 50, (potion.get(1).pNum) - num));

			//체력 증가 세터
			
			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 100, (potion.get(2).pNum) - num));

			//체력 증가 세터
			
			break;

		}
		
		
	}
	
	
	
	

}
