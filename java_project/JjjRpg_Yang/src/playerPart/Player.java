package playerPart;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import items.A_Hat;
import items.A_HeadPiece;
import items.B_DiamondArmor;
import items.B_OldArmor;
import items.B_ShiningArmor;
import items.C_InvisibilityCloak;
import items.C_OldCloak;
import items.C_ShiningCloak;
import items.D_DiamondWand;
import items.D_GoldWand;
import items.D_SilverWand;
import items.Inventory;
import potionStore.Potion;
import potionStore.PotionInven;

public class Player extends Entity {

	// 변수선언
	// private String name;
	// private int currentStrength;;
	// private int currentHealth;
	// private int maxHealth;
	// private float evasion;
	//장비 인스턴스 생성
			public A_Hat A1 = new A_Hat("", 0, 0, 0, 0, 0);

			A_HeadPiece A2 = new A_HeadPiece("", 0, 0, 0, 0, 0);

			B_OldArmor B1 = new B_OldArmor("", 0, 0, 0, 0, 0);

			B_ShiningArmor B2 = new B_ShiningArmor("", 0, 0, 0, 0, 0);

			B_DiamondArmor B3 = new B_DiamondArmor("", 0, 0, 0, 0, 0);

			C_OldCloak C1 = new C_OldCloak("", 0, 0, 0, 0, 0);

			C_ShiningCloak C2 = new C_ShiningCloak("", 0, 0, 0, 0, 0);

			C_InvisibilityCloak C3 = new C_InvisibilityCloak("", 0, 0, 0, 0, 0);

			D_SilverWand D1 = new D_SilverWand("", 0, 0, 0, 0, 0);

			D_GoldWand D2 = new D_GoldWand("", 0, 0, 0, 0, 0);

			D_DiamondWand D3 = new D_DiamondWand("", 0, 0, 0, 0, 0);
			
			public Inventory inven = new Inventory();
			
			
	private PotionInven p;
	private int gold;
	private int currentLevel;
	private int currentExp;
	private int levelUpExp;
	private Scanner sc;
	public ArrayList<Potion> potion = new ArrayList<Potion>(3);

	// S M L
	public Potion sp = new Potion("Small Potion", 30, 0, 20);

	public Potion np = new Potion("Normal Potion", 60, 0, 30);

	public Potion bp = new Potion("Big Potion", 150, 0, 60);

	public Player() {
		super.setName("");
		currentLevel = BasicInfo.BASIC_LEVEL;
		super.setCurrentHealth(BasicInfo.BASIC_HEALTH);
		super.setMaxHealth(BasicInfo.BASIC_HEALTH);
		super.setCurrentStrength(BasicInfo.BASIC_POWER);
		super.setEvasion(0);
		gold = BasicInfo.BASIC_GOLD;
		currentExp = 0;
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
		p = new PotionInven();
	}

	// 캐릭터의 이름을 받는 메서드
	void addName() {
//
//		System.out.println("캐릭터의 이름을 입력해주세요.");
//		name = sc.nextLine();

		super.setName(JOptionPane.showInputDialog("캐릭터의 이름을 입력해주세요."));

		while (true) {
			System.out.println("입력하신 이름이 " + super.getName() + "님이 맞습니까? 맞으면 y 틀리면n");
			String check = sc.nextLine();

			if (check.equals("y") || check.equals("Y")) {
				System.out.println("캐릭터가 생성되었습니다!");
				break;

			} else if (check.equals("n") || check.equals("N")) {
				addName();
				break;
			} else {
				System.out.println("잘못 누르셨습니다.");
				continue;
			}

		}
		// return name;

	}

	// 경험치 획득 메서드
	void getExp(int Exp) {

		currentExp = currentExp + Exp;

		// return currentExp;
	}

	// 체력의 변화를 반환하는 메서드
	void getCurrnetHeatlh(int health) {

		super.setCurrentHealth(super.getCurrentHealth() + health);

		if (super.getCurrentHealth() > super.getMaxHealth()) {

			super.setCurrentHealth(super.getMaxHealth());

		}

		if (super.getCurrentHealth() <= 0) {

			super.setCurrentHealth(0);

			System.out.println(super.getName() + "님이 사망하셨습니다.");

		}

	}

//	// 체력이 0이되면 죽는걸 반환하는 메서드
//	void checkHealth() {
//		if (currentHealth<=0) {
//		
//			currentHealth = 0;
//			
//			System.out.println(name+"님이 사망하셨습니다.");
//		
//		}
//	}

	// 경험치 값을 확인해 레벨업 및 스테이터스 업데이트를 하는 메서드
	int checkLevelUp() {
		while (true) {
			if (currentExp >= levelUpExp) {

				currentExp = currentExp - levelUpExp;

				currentLevel++;

				levelUpExp = (int) (levelUpExp * 1.3f);
				super.setMaxHealth((int) (super.getMaxHealth() * 1.3f) / 1);
				super.setCurrentHealth((int) super.getMaxHealth());
				super.setCurrentStrength((int) (super.getCurrentStrength() * 1.3f));
				super.setEvasion(super.getEvasion() + 1);

				System.out.println("레벨업 하였습니다!\n");

				System.out.println("레벨 : " + currentLevel + " UP↑");
				System.out.println("HP : " + super.getCurrentHealth() + "/" + super.getMaxHealth());
				System.out.println("공격력 : " + super.getCurrentStrength());
				System.out.println("회피율 : " + super.getEvasion() + "%");
				System.out.println("EXP : " + currentExp + "/" + levelUpExp);
				System.out.println("+++++++++++++++++++++++++++++++++");
				if (currentExp < levelUpExp) {
					break;
				}

			}
		}

		return currentLevel;
	}

	// 골드 변화 메서드
	void getGold(Monster m) {
		this.gold = this.gold + m.getGoldWorth();

		System.out.println();
		// return gold;
	}

	void showStatus() {
		System.out.println("================================");
		System.out.println("레벨 : " + currentLevel);
		System.out.println("HP : " + super.getCurrentHealth() + "/" + super.getMaxHealth());
		System.out.println("공격력 : " + super.getCurrentStrength());
		System.out.println("회피율 : " + super.getEvasion() + "%");
		System.out.println("EXP : " + currentExp + "/" + levelUpExp);

	}

	void addEquipStat() {

		super.setMaxHealth(super.getMaxHealth()); // 최대체력 +장비체력

		super.setCurrentHealth(super.getCurrentHealth()); // 현재체력 +장비체력

		super.setEvasion(super.getEvasion()); // 회피율 +장비회피율

		super.setCurrentStrength(super.getCurrentStrength()); // 공격력 +장비공격력

	}

	// 레벨업 계산시 능력치를 빼주었다가 추가하기 위한 메서드
	void minEquipStat() {

		super.setMaxHealth(super.getMaxHealth()); // 최대체력 - 장비체력

		super.setCurrentHealth(super.getCurrentHealth()); // 현재체력 -장비체력

		super.setEvasion(super.getEvasion()); // 회피율 +장비회피율

		super.setCurrentStrength(super.getCurrentStrength()); // 공격력 -장비공격력

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

			// 돈 증감 세터
			gold = gold + 20 * num;

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 60, (potion.get(1).pNum) + num, 30));
			gold = gold + 30 * num;

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 150, (p.potion.get(2).pNum) + num, 60));
			gold = gold + 60 * num;
			// 돈 증감 세터

			break;

		}

		System.out.println(potion.get(i - 1).pName + ", " + potion.get(i - 1).pNum);

		System.out.println(potion.toString());

	}

	// 포션 사용 메서드
	public void usePotion(int i) {

		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) - 1, 20));

			// 체력 증가 세터

			setCurrentHealth(getCurrentHealth() + 30);

			if (getCurrentHealth() > getMaxHealth()) {
				setCurrentHealth(getMaxHealth());
			}

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 60, (potion.get(1).pNum) - 1, 30));

			// 체력 증가 세터
			setCurrentHealth(getCurrentHealth() + 60);

			if (getCurrentHealth() > getMaxHealth()) {
				setCurrentHealth(getMaxHealth());
			}

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 150, (potion.get(2).pNum) - 1, 60));

			// 체력 증가 세터

			setCurrentHealth(getCurrentHealth()+150);
			
			if(getCurrentHealth()>getMaxHealth()) {
				setCurrentHealth(getMaxHealth());
			}
			break;

		}

	}

	public void showPotion() {

		System.out.println(potion.toString());

	}

}
