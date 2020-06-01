package employeeBookManager;

import java.util.Scanner;

import employeeBookManager.Menu;
import employeeBookManager.EmployeeBookManager;

public class EmployeeBookMain {

	public static void main(String[] args) {

		EmployeeBookManager manager = EmployeeBookManager.getInstance();

		int selectNum;
		Scanner sc = new Scanner(System.in);

		while (true) {
			Menu.showMenu();

			selectNum = sc.nextInt();
			sc.nextLine();
			switch (selectNum) {
			case MenuInterface.INSERT:

				manager.empInsert();

				break;
			case MenuInterface.SEARCH:

				manager.empSearch();

				break;

			case MenuInterface.DELETE:

				manager.empDelete();

				break;

			case MenuInterface.EDIT:

				manager.empEdit();
				break;
			case MenuInterface.SHOWALL:
				manager.showData();

				break;
			case MenuInterface.EXIT:
				System.exit(0);

				break;

			}
		}
	}

}
