package versionA4;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = new PhoneBookManager();

		Scanner sc = new Scanner(System.in);

		while (true) {

			Menu.menu();

			int select = sc.nextInt();
			switch (select) {

			case 1:

				manager.createInstance();

				break;
			case 2:
				manager.searchInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.editInfo();
				break;
			case 5:
				manager.showAllData();
				break;
			case 6:
				//return;
			System.exit(0);

			}

		}

	}

}
