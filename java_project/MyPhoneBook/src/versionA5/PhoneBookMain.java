package versionA5;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.getInstance();

		Scanner sc = new Scanner(System.in);

		while (true) {

			Menu.menu();

			int select = sc.nextInt();
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
