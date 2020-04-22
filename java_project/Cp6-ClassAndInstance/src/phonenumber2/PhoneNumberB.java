package phonenumber2;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumberB {
	private int i = 0;
	private String name;
	private String phoneNumber;
	PhoneNumberB result;
	boolean isTrue = false;

	@Override
	public String toString() {
		return "PhoneNumberB [i=" + i + ", name=" + name + ", phoneNumber=" + phoneNumber + ", birthday=" + birthday
				+ "]";
	}

	private String birthday;
	PhoneNumberB[] array = new PhoneNumberB[100];

	public PhoneNumberB(String n, String num) {
		name = n;
		phoneNumber = num;
		birthday = "000000";
	}

	public PhoneNumberB(String n, String p, String b) {
		name = n;
		phoneNumber = p;
		birthday = b;

	}

	public PhoneNumberB() {
	}

	void saveInfo(PhoneNumberB info) {
		if (array[i] == null) {
			array[i] = info;
		}
		i++;
	}

	PhoneNumberB showInfo(int a) {

		PhoneNumberB information = array[a];

		return information;

	}

	// 이름을 받아서 배열안에있는 참조값 안에있는 name값과 비교후 같은 값의 행 참조값을 반환해주는 걸 반복문안에 넣음
	// 수정 - 이름값을 주고 참조값 안에있는 name값과 같은게 있다면 불리언값을 반환하는 메서드로 수정 *요약 - 반복문 제거
	// 수정2 - 이름을 주면 같은값을 찾는 기능을 반복문안에 넣어서 출력해주는 기능
	void searchInfo(String name) {
		for (int i = 0; i < array.length; i++) {

			if (name.equals(array[i].name)) {
				System.out.println("------------------------------------------------------");
				System.out.println("------------------------------------------------------");
				System.out.println(array[i].toString());
				break;
			}
		}
		
		
//		if (t<0) {
//			return;
//		}
//		isTrue = array[t].name.equals(name);
//		if(array[t]==null) {
//			searchInfo(name, --t);
//		}
//		
//		else if(isTrue) {
//			result = array[t];
//			System.out.println(result.toString());
//		} 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhoneNumberB save = new PhoneNumberB();
		
		String n;
		String p;
		String b;
		int select = 0;
		String search = "";
		while (true) {

			for (PhoneNumberB e : save.array) {
				System.out.println(e);
			}

			System.out.println("---------------");

			System.out.println("1.저장 2.검색 3.삭제");

			System.out.println("---------------");
			select = sc.nextInt();

			if (select == 1) {
				while (true) {
					System.out.println("이름, 연락처, 생일 입력");
					n = sc.next();
					p = sc.next();
					b = sc.next();

					PhoneNumberB info = new PhoneNumberB(n, p, b);

					save.saveInfo(info);
//					System.out.println(save.showInfo(0).toString());
					System.out.println("계속하려면 1, 메뉴로 돌아가려면 0");

					select = sc.nextInt();

					if (select == 1) {
						continue;

					} else {
						break;
					}

				}
				continue;

			}

			else if (select == 2) {
				System.out.println("이름을 입력해주세요");
				search = sc.next();
				System.out.println(search);

				save.searchInfo(search);

				// for문으로 제한을 어디까지 둘지 고민중
//				for(int ii=0;ii<100;ii++) {
//					
//					
//						save.searchInfo(search,ii);
//					
//						
//						
//			
//					
//
//				} // 반복문을 메서드에 썼다가 충돌로인하여 출력쪽으로 빼냄

//				System.out.println(inforSearch);
//				System.out.println("이름 : " + save.showInfo(search).name + " 번호 : " + save.showInfo(search).phoneNumber
//						+ " 생일 : " + save.showInfo(search).birthday);

			} else {
				continue;
			}
			continue;

		}
	}

}
