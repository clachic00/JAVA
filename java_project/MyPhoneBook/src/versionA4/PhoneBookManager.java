package versionA4;

import java.util.Scanner;

public class PhoneBookManager {

	Scanner sc;
	int cnt;
	PhoneInfor pBooks[];

	public PhoneBookManager() {
		cnt = 0;
		sc = new Scanner(System.in);
		pBooks = new PhoneInfor[100];
	}

	void addinfo(PhoneInfor info) {

		pBooks[cnt] = info;

		cnt++;
	}

	void showAllData() {
		for (int i = 0; i < cnt; i++) {
			pBooks[i].showData();
			System.out.println("========================");
		}

	}

	void createInstance() {

		Menu.selectFriend();

		int choice = sc.nextInt();
		sc.nextLine();

		PhoneInfor info = null;

		System.out.println("이름을 입력해주세요");

		String name = sc.nextLine();

		System.out.println("번호를 입력해주세요");

		String phoneNumber = sc.nextLine();

		if (choice == 1) {

			System.out.println("생일을 입력해주세요");

			String birthday = sc.nextLine();

			if (birthday == null || birthday.trim().isEmpty()) {

				info = new PhoneInfor(name, phoneNumber);
			} else {
				info = new PhoneInfor(name, phoneNumber, birthday);
			}

		} else if (choice == 2) {

			System.out.println("주소를 입력해주세요");

			String address = sc.nextLine();

			System.out.println("이메일을 입력해주세요");

			String email = sc.nextLine();

			System.out.println("전공을 입력해주세요");

			String major = sc.nextLine();

			System.out.println("학년을 입력해주세요");

			String year = sc.nextLine();

			info = new PhoneUnivInfor(name, phoneNumber, address, email, major, Integer.parseInt(year));

		} else { // choice == 3

			System.out.println("주소를 입력해주세요");

			String address = sc.nextLine();

			System.out.println("이메일을 입력해주세요");

			String email = sc.nextLine();

			System.out.println("회사를 입력해주세요");

			String company = sc.nextLine();

			info = new PhoneCompanyInfor(name, phoneNumber, address, email, company);

		}

		addinfo(info);
	}

	int searchIndex(String name) {
		int searchIndex = -1;

		for (int i = 0; i < cnt; i++) {

			if (pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}

		}

		return searchIndex;

	}

	void searchInfo() {
		System.out.println("이름으로 검색해주세요");

		String name = sc.nextLine();

		int searchIndex = searchIndex(name);

		if (searchIndex < 0) {
			System.out.println("입력하신 정보가 없습니다");
		} else {
			pBooks[searchIndex].showData();
		}

	}

	void deleteInfo() {
		System.out.println("이름으로 검색해주세요");
		String name = sc.nextLine();

		int searchIndex = -1;
		for (int i = 0; i < cnt; i++) {

		

			if (pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}

		}

		if (searchIndex < 0) {
			System.out.println("입력하신 정보가 없습니다 삭제되지 않았습니다");
		} else {
			for (int deleteIndex = searchIndex; deleteIndex <= cnt; deleteIndex++) {
				pBooks[deleteIndex] = pBooks[deleteIndex + 1];

			}

			cnt--;
			System.out.println("삭제되었습니다");
		}

	}

	void editInfo() {
		System.out.println("이름으로 검색해주세요");
		String name = sc.nextLine();

		int searchIndex = -1;
		for (int i = 0; i < cnt; i++) {


			if (pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}

		}
		System.out.println(searchIndex);
		if (searchIndex < 0) {
			System.out.println("입력하신 정보가 없습니다");
		} else {
			System.out.println("수정을 시작합니다.");
			String editName = pBooks[searchIndex].getName();
			System.out.println("수정할 이름은 " + editName + " 입니다.");

			System.out.println("번호를 입력해주세요");

			String phoneNumber = sc.nextLine();

			PhoneInfor info = null;

			if (pBooks[searchIndex] instanceof PhoneUnivInfor) {
				System.out.println("주소를 입력해주세요");

				String address = sc.nextLine();

				System.out.println("이메일을 입력해주세요");

				String email = sc.nextLine();
				System.out.println("전공을 입력해주세요");
				String major = sc.nextLine();
				System.out.println("학년을 입력해주세요");
				String year = sc.nextLine();

				info = new PhoneUnivInfor(editName, phoneNumber, address, email, major, Integer.parseInt(year));
			} else if (pBooks[searchIndex] instanceof PhoneCompanyInfor) {
				
				System.out.println("주소를 입력해주세요");

				String address = sc.nextLine();

				System.out.println("이메일을 입력해주세요");

				String email = sc.nextLine();

				System.out.println("회사를 입력해주세요");

				String company = sc.nextLine();
				
				
				info = new PhoneCompanyInfor(editName, phoneNumber, address, email, company);
			} else if (pBooks[searchIndex] instanceof PhoneInfor) {
				
				System.out.println("생일을 입력해주세요");

				String birthday = sc.nextLine();
				
				
				info = new PhoneInfor(editName, phoneNumber, birthday);
			}

			
			pBooks[searchIndex] = info;
			
			
		}

	}

}
