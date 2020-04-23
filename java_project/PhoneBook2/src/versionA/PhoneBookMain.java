package versionA;

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
				PhoneInfor info = manager.createInstance();
				manager.addinfo(info);
				break;
			case 2:
				manager.searchInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.showAllData();
				break;

			case 5:
				System.exit(0);

			}

		}

	}

}
