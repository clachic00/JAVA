package friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {

//	2020.04.28
//	1. 클래스의 싱글톤 패턴 처리
//	   1) 생성자 접근제어지시자 : private
//	      인스턴스 생성 막는다
//	   2) 공동으로 사용할 인스턴스를 생성 : static private
//	   3) 참조변수 반환 메서드 : static
//
//
//	2. interface 기반의 상수 표현
//	   메뉴표현
//	3. interface ->추상클래스 ->상속 관계 구조로 변경
	
	
	static private FriendInfoHandler handler = new FriendInfoHandler(100);
	
	public static FriendInfoHandler getInstance() {
		return handler;
	}
	
	
	// Friend 타입의 정보를 저장할 배열을 가진다.
	// 친구정보를 저장하는 기능
	// 친구정보를 기본 정보 출력 기능
	// 친구정보 상세 정보 출력 기능

	
	// List 참조변수
	
	private ArrayList<Friend> myFriends;
	
	
	
	
	
	
	
	//private Friend[] myFriends; // Friend 타입의 배열 선언
	private int numOfFriend; // 저장된 친구의 정보 개수
	Scanner sc;

	// 초기화
	private FriendInfoHandler(int num) {

		myFriends = new ArrayList<Friend>();
		sc = new Scanner(System.in);
		numOfFriend = 0;

	}

	// 친구정보를 저장하는 기능
	// 1. 배열에 저장하는 기능

	// 1. 배열에 저장하는 기능
	void addFriendInfo(Friend f) {
		// 배열에 저장

		//myFriends[numOfFriend] = f;
		//numOfFriend++;
	
		myFriends.add(f);
	
	
	}

	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	// HeighFriend / UnivFriend
	void addFreind(int choice) {

		// 기본정보 받기
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력해주세요");
		String phoneNum = sc.nextLine();

		System.out.println("주소를 입력해주세요");
		String addr = sc.nextLine();

		Friend friend = null;

		if (choice == 1) {
			// 1일때 정보 받기
			System.out.println("직업을 입력해주세요");
			String work = sc.nextLine();
			// highFriend 인스턴스
			friend = new HighFriend(name, phoneNum, addr, work);

		} else {
			// 2일때 정보 받기

			System.out.println("전공을 입력해주세요");
			String major = sc.nextLine();
			System.out.println("등급을 숫자로 입력해주세요");
			String grade = sc.nextLine();
//				Integer.parseInt(grade);

			// univFriend 인스턴스
			friend = new UnivFriend(name, phoneNum, addr, major, Integer.parseInt(grade));

			// addFriendinfo 호출

			

		}
		
	
		addFriendInfo(friend);
	}

	// 1일때 정보 받기

	// highFriend 인스턴스

	// 2일때 정보 받기

	// univFriend 인스턴스

	// addFriendinfo 호출

	// 친구정보의 기본 정보 출력 기능
	void showAllSimpleData() {

		System.out.println("=======친구의 기본정보를 출력합니다 ========");

		for (int i = 0; i < myFriends.size(); i++) {
			myFriends.get(i).showBasicInfo();
			System.out.println("================================");

		}

	}

	// 친구정보의 상세 정보 출력 기능

	void showAllData() {
		System.out.println("=======친구의 모든정보를 출력합니다 ========");
		for (int i = 0; i < numOfFriend; i++) {
			myFriends.get(i).showData();
			System.out.println("================================");

		}

	}

}
