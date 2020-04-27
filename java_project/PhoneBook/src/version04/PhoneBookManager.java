package version04;

import java.util.Scanner;

public class PhoneBookManager {

	final PhoneInfor[] pBooks;
	// 입력된 친구의 정보 개수 -> 입력된 배열의 요소 개수
	// 1. 참조할 때 반복의 횟수
	// 2. 새로운 객체를 저장할 때 index를 사용
	int cnt;
	Scanner sc;

	public PhoneBookManager() {
		pBooks = new PhoneInfor[100];
		cnt = 0;

		sc = new Scanner(System.in);
	}

	// 2. 배열에 정보 저장
	// 2.1 배열에 추가
	// 2.2 사용자로분터 받은 데이터로 인스턴스 생성

	// 2.1 배열에 추가
	void addInfo(PhoneInfor info) {
		// 배열에 cnt 숫자 -> index로 참조값을 저장
		pBooks[cnt] = info;
		// 입력된 정보의 개수를 +1 증가 시킨다
		cnt++;

	}

	// 2.2.1 기본 정보 수집 : 이름, 전번, 주소, 이메일
	// 2.2.2 기본 클래스로 인스턴스 생성
	// 2.2.3 대학 클래스로 인스턴스 생성
	// 2.2.4 회사 클래스로 인스턴스 생성
	// 2.2.5 동호회 클래스로 인스턴스 생성
	// 2.2.2 기본 클래스로 인스턴스 생성
	// 2.3 생성된 인스턴스를 배열에 저장

	// 사용자의 입력데이터 phoneInfor 객체를 생성
	void createInstance() {

		PhoneInfor info = null;

		System.out.println("1.일반   2.대학  3.회사  4.동호회");
		System.out.println("===================================");
//		int select = sc.nextInt();
//		sc.nextLine();
		int select = Integer.parseInt(sc.nextLine());

		if (0 >= select || select >= 5) {
			System.out.println("잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
			return;
		}
		System.out.println("친구의 정보를 입력하기 위한 데이터를 입력합니다.");
		System.out.println("이름을 입력해주세요. >> ");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력해주세요. >> ");
		String phoneNumber = sc.nextLine();

		System.out.println("주소를 입력해주세요. >> ");
		String addr = sc.nextLine();

		System.out.println("이메일을 입력해주세요. >> ");
		String email = sc.nextLine();

		switch (select) {
		case 1:
			info = new PhoneInfor(name, phoneNumber, addr, email);
			break;
		case 2:

			System.out.println("전공을 입력해주세요. >> ");
			String major = sc.nextLine();

			System.out.println("학년을 입력해주세요. >> ");
			String grade = sc.nextLine();

			info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;

		case 3:

			System.out.println("회사를 입력해주세요. >> ");
			String company = sc.nextLine();
			System.out.println("부서를 입력해주세요. >> ");
			String dept = sc.nextLine();
			System.out.println("직책을 입력해주세요. >> ");
			String job = sc.nextLine();
			info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;

		case 4:

			System.out.println("동호회명을 입력해주세요. >> ");
			String cafeName = sc.nextLine();
			System.out.println("닉네임를 입력해주세요. >> ");
			String nickName = sc.nextLine();

			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);

			break;

		}
		addInfo(info);

	}

	// 전체 리스트 출력
	void showAllData() {
		// 전체 데이터-> 입력된 데이터의 개수 cnt
		System.out.println("=====전체 정보를 출력합니다.======");
		for (int i = 0; i < cnt; i++) {
			pBooks[i].showAllInfo();
			System.out.println("========================");
		}

	}

	// 배열에서 이름을 기준으로 검색후 index 값을 반환
	int searchIndex(String name) {
		// 정상적인 index값은 0이상, 찾지 못했을 때는 구분 값 -1을 사용
		int searchIndex = -1;

		for (int i = 0; i < cnt; i++) {
			if (pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}

		}
		return searchIndex;
	}

	// 검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	// 배열의 요소(PhoneInfor)의 name 속성 값으로 배열의 요소

	void searchInfo() {
		System.out.println("이름으로 검색해주세요");

		String name = sc.nextLine();

		int searchIndex = searchIndex(name);
//		// 사용자가 입력한 이름으로 배열에 요소를 검색 -> index
//		for (int i = 0; i < cnt; i++) {
//			if (pBooks[i].checkName(name)) {
//				searchIndex = i;
//				break;
//			}
//
//		}

		if (searchIndex < 0) {
			System.out.println("검색하고자하는 이름이 존재하지않습니다");
		} else {
			pBooks[searchIndex].showAllInfo();
		}

	}

	// pBooks[2] : 삭제, pBooks[2] = null
	// 데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
	// 재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
	void deleteInfo() {
		System.out.println("이름으로 삭제해주세요");

		String name = sc.nextLine();

		int searchIndex = searchIndex(name);
//		// 사용자가 입력한 이름으로 배열에 요소를 검색 -> index
//		for (int i = 0; i < cnt; i++) {
//			if (pBooks[i].checkName(name)) {
//				searchIndex = i;
//				break;
//			}
//
//		}

		if (searchIndex < 0) {
			System.out.println("검색하고자하는 이름이 존재하지 않아 삭제되지 않았습니다.");
		} else {
			// 삭제 : 검색한 index 부터 저장된 위치까지 왼쪽으로 시프트
			for (int i = searchIndex; i < cnt - 1; i++) {
				pBooks[i] = pBooks[i + 1];
			}
			cnt--;
			System.out.println("삭제가 완료되었습니다.");
			pBooks[searchIndex].showAllInfo();
		}

	}

	void editInfo() {
		System.out.println("변겅하고자 하는 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);
		if (index < 0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다");
			return;
		} else {
			// 저장된 인스턴스가 : 일반, 대학, 회사, 동호회

			String editName = pBooks[index].name;
			System.out.println("수정 데이터 입력을 시작합니다");
			System.out.println("이름은" + editName + "입니다");
			System.out.println("전화번호를 입력해주세요");
			String phoneNumber = sc.nextLine();
			System.out.println("주소를 입력해주세요");
			String addr = sc.nextLine();

			System.out.println("이메일을 입력해주세요");
			String email = sc.nextLine();

			PhoneInfor info = null;

			if (pBooks[index] instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력해주세요");
				String major = sc.nextLine();
				System.out.println("학년을 입력해주세요");
				String grade = sc.nextLine();

				info = new PhoneUnivInfo(editName, phoneNumber, addr, email, major, grade);

			} else if (pBooks[index] instanceof PhoneCompanyInfo) {

				System.out.println("회사를 입력해주세요");
				String company = sc.nextLine();
				System.out.println("부서를 입력해주세요");
				String dept = sc.nextLine();
				System.out.println("직책을 입력해주세요");
				String job = sc.nextLine();

				info = new PhoneCompanyInfo(editName, phoneNumber, addr, email, company, dept, job);

			} else if (pBooks[index] instanceof PhoneCafeInfo) {

				System.out.println("동호회명을 입력해주세요");
				String cafeName = sc.nextLine();
				System.out.println("닉네임을 입력해주세요");
				String nickName = sc.nextLine();

				info = new PhoneCafeInfo(editName, phoneNumber, addr, email, cafeName, nickName);

			}

			else if (pBooks[index] instanceof PhoneInfor) {
				info = new PhoneInfor(editName, phoneNumber, addr, email);
				
			} 
			
			
			
			// 배열에 새로운 인스턴스를 저장

			pBooks[index] = info;

		}
	}

}
