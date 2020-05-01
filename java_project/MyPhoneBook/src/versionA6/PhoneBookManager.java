package versionA6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import versionA5_Exception.BadNumberException;
import versionA5_Exception.StringEmptyException;

public class PhoneBookManager {

	static private PhoneBookManager manager = new PhoneBookManager();

	static PhoneBookManager getInstance() {
		return manager;
	}

	private Scanner sc;
	// private int cnt;
	// private PhoneInfor pBooks[];
	private ArrayList<PhoneInfor> pBooks;

	private PhoneBookManager() {
		// cnt = 0;
		sc = new Scanner(System.in);
		pBooks = new ArrayList<PhoneInfor>();
	}

	void addinfo(PhoneInfor info) {

		/*
		 * pBooks[cnt] = info; cnt++;
		 */

		pBooks.add(info);

	}

	void showAllData() {
		for (int i = 0; i < pBooks.size(); i++) {
			pBooks.get(i).showData();
			System.out.println("========================");
		}

	}

	void createInstance() {

		Menu.selectFriend();

//		int choice = sc.nextInt();
//		sc.nextLine();

		int choice = 0;

		try {
			choice = Integer.parseInt(sc.nextLine());
			// select = sc.nextInt();
			if (!(choice >= MenuInterface.UNIV && choice <= MenuInterface.CAFE)) {
				BadNumberException e = new BadNumberException("잘못된 메뉴입력");

				throw e;

			}

		} catch (InputMismatchException e) {
			System.out.println("잘못된 메뉴 입력입니다 \n메뉴로돌아갑니다");
			return;
		} catch (BadNumberException e) {
			System.out.println("잘못된 메뉴 입력입니다 \n메뉴로돌아갑니다");
			return;
		} catch (Exception e) {
			System.out.println("잘못된 메뉴 입력입니다 \n메뉴로돌아갑니다");
			return;
		}

//		if (choice < 1 || choice > 3) {
//			System.out.println("잘못 누르셨습니다 메뉴로돌아갑니다");
//			return;
//		}
		while (true) {
			PhoneInfor info = null;

			System.out.println("이름을 입력해주세요");

			String name = sc.nextLine();

			System.out.println("번호를 입력해주세요");

			String phoneNumber = sc.nextLine();

			System.out.println("주소를 입력해주세요");

			String address = sc.nextLine();

			System.out.println("이메일을 입력해주세요");

			String email = sc.nextLine();

			try {
				if (name.trim().isEmpty() || phoneNumber.trim().isEmpty() || address.trim().isEmpty()
						|| email.trim().isEmpty()) {

					StringEmptyException e = new StringEmptyException();

					throw e;

				}

			} catch (StringEmptyException e) {
				System.out.println("공백없이 입력해주세요");
				continue;
			}

			if (choice == MenuInterface.UNIV) {
				int year;
				String major;

				while (true) {

					System.out.println("전공을 입력해주세요");

					major = sc.nextLine();

					System.out.println("학년을 입력해주세요");

					year = 0;
					try {
						year = sc.nextInt();

					} catch (InputMismatchException e) {
						System.out.println("정수로 입력해주세요");

						continue;

					} finally {
						sc.nextLine();
					}

					info = new PhoneUnivInfor(name, phoneNumber, address, email, major, year);

					break;
				}

			} else if (choice == MenuInterface.COMPANY) {

				System.out.println("회사를 입력해주세요");

				String company = sc.nextLine();

				info = new PhoneCompanyInfor(name, phoneNumber, address, email, company);

			} else if (choice == MenuInterface.CAFE) {

				System.out.println("동호회명을 입력해주세요");

				String cafeName = sc.nextLine();

				System.out.println("닉네임을 입력해주세요");

				String nickName = sc.nextLine();

				info = new PhoneCafeInfor(name, phoneNumber, address, email, cafeName, nickName);

			}

			addinfo(info);

			break;

		}

	}

	int searchIndex(String name) {
		int searchIndex = -1;

		for (int i = 0; i < pBooks.size(); i++) {

			if (pBooks.get(i).checkName(name)) {
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
			pBooks.get(searchIndex).showData();
		}

	}

	void deleteInfo() {
		System.out.println("이름으로 검색해주세요");
		String name = sc.nextLine();

		int searchIndex = -1;
		for (int i = 0; i < pBooks.size(); i++) {

			if (pBooks.get(i).checkName(name)) {
				searchIndex = i;
				break;
			}

		}

		if (searchIndex < 0) {
			System.out.println("입력하신 정보가 없습니다 삭제되지 않았습니다");
		} else {
			pBooks.remove(searchIndex);

		}

		System.out.println("삭제되었습니다");
	}

	void editInfo() {
		System.out.println("이름으로 검색해주세요");
		String name = sc.nextLine();

		int searchIndex = -1;
		for (int i = 0; i < pBooks.size(); i++) {

			if (pBooks.get(i).checkName(name)) {
				searchIndex = i;

				break;
			}

		}

		if (searchIndex < 0) {
			System.out.println("입력하신 정보가 없습니다");
		} else {
			System.out.println("수정을 시작합니다.");
			String editName = pBooks.get(searchIndex).getName();
			System.out.println("수정할 이름은 " + editName + " 입니다.");

			System.out.println("번호를 입력해주세요");

			String phoneNumber = sc.nextLine();

			PhoneInfor info = null;

			if (pBooks.get(searchIndex) instanceof PhoneUnivInfor) {
				System.out.println("주소를 입력해주세요");

				String address = sc.nextLine();

				System.out.println("이메일을 입력해주세요");

				String email = sc.nextLine();
				System.out.println("전공을 입력해주세요");
				String major = sc.nextLine();
				System.out.println("학년을 입력해주세요");
				String year = sc.nextLine();

				info = new PhoneUnivInfor(editName, phoneNumber, address, email, major, Integer.parseInt(year));
			} else if (pBooks.get(searchIndex) instanceof PhoneCompanyInfor) {

				System.out.println("주소를 입력해주세요");

				String address = sc.nextLine();

				System.out.println("이메일을 입력해주세요");

				String email = sc.nextLine();

				System.out.println("회사를 입력해주세요");

				String company = sc.nextLine();

				info = new PhoneCompanyInfor(editName, phoneNumber, address, email, company);
			}
//			pBooks.remove(searchIndex);
//			pBooks.add(searchIndex, info);
			pBooks.set(searchIndex, info);
		
		
		}

	}

}
