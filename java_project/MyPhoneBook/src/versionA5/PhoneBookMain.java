package versionA5;

import java.util.InputMismatchException;
import java.util.Scanner;

import versionA5_Exception.BadNumberException;



public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.getInstance();

		Scanner sc = new Scanner(System.in);

		while (true) {

			Menu.menu();

			int select = 0;

			try {
				select =  Integer.parseInt(sc.nextLine());
				//	select =  sc.nextInt();
				if (!(select >= MenuInterface.SAVE && select <= MenuInterface.EXIT)) {
					BadNumberException e = new BadNumberException("잘못된 메뉴입력");

					throw e;

			}

		} catch (InputMismatchException e) {
			System.out.println("잘못된 메뉴 입력입니다 \n메뉴로돌아갑니다");
			continue;
		} catch (BadNumberException e) {
			System.out.println("잘못된 메뉴 입력입니다 \n메뉴로돌아갑니다");
			continue;
		} catch (Exception e) {
			System.out.println("잘못된 메뉴 입력입니다 \n메뉴로돌아갑니다");
			continue;
		}
			// finally {
			// sc.nextLine();
			// }
			

			
			
			
			
			switch (select) {

			case MenuInterface.SAVE:

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

			}

		}

	}

}
