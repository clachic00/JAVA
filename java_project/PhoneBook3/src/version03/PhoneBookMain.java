package version03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBookManager pb = new PhoneBookManager();

		while (true) {

			Menu.menu();

			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();

			switch (select) {

			case 1:
				pb.addInfo();
				break;
			case 2:
				pb.searchInfo();
				break;
			case 3:
				pb.deleteInfo();
				break;
			case 4:
				pb.ShowAllData();
				break;
			case 5:
				System.exit(0);

			}

		}

//		pb.addInfo();
//		
//		pb.searchInfo();
//		
//		pb.deleteInfo();

	}
}
