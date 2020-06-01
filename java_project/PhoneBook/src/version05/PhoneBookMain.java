package version05;

import java.util.InputMismatchException;

import version05_Exception.BadNumberException;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.getInstance();

		while (true) {

			Menu.showMenu();

			int selectNum = 0;
			try {
				selectNum =  manager.sc.nextInt();

				// 정상범위는 1~6
				// MenuNum.INSERT~MenuNum.EXIT

				if (!(selectNum >= MenuInterface.INSERT && selectNum <= MenuInterface.EXIT)) {
					BadNumberException e = new BadNumberException("잘못된 메뉴입력");

					throw e;

				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다 \n확인하시고 다시 입력해주세요");
				continue;
			} catch (BadNumberException e) {
				System.out.println("잘못된 메뉴 입력입니다 \n확인하시고 다시 입력해주세요");
				continue;
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다 \n확인하시고 다시 입력해주세요");
				continue;
			} finally {
				manager.sc.nextLine();

			}

			// manager.sc.nextLine();

			

			switch (selectNum) {
			case MenuInterface.INSERT:
//				PhoneInfor info = manager.createInstance();
//				manager.addInfo(info);
				manager.createInstance();

				break;
			case MenuInterface.SEARCH:
				manager.searchInfo();
				break;

			case MenuInterface.DELETE:
				manager.deleteInfo();
				break;

			case MenuInterface.EDIT:
				manager.editInfo();
				break;
			case MenuInterface.SHOWALL:
				manager.showAllData();
				break;
			case MenuInterface.EXIT:
				// return;
				System.exit(0);

				break;

			}

//			// 사용자의 입력 데이터 인스턴스 생성
//			info = manager.createInstance();
//			
//			manager.addInfo(info);
//			
//			manager.showAllData();
//			
//			manager.searchInfo();
//			
//			manager.deleteInfo();
//			
//			manager.showAllData();
//		

		}

	}
}
