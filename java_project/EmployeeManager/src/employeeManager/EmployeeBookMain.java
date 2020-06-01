package employeeManager;

import java.util.Scanner;

import employeeManager.EmployeeBookManager;
import employeeManager.Menu;

public class EmployeeBookMain {

	public static void main(String[] args) {

		EmployeeBookManager manager = EmployeeBookManager.getInstance();

		int selectNum;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 사원정보 \n2. 부서정보");
			selectNum = sc.nextInt();
			sc.nextLine();

			if (selectNum == 1) {

				Menu.showEmpMenu();

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
					manager.empList();

					break;
				case MenuInterface.EXIT:
					System.exit(0);

					break;

				}
			}

			else if (selectNum == 2) {

				Menu.showDeptMenu();

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
					manager.empList();

					break;
				case MenuInterface.EXIT:
					System.exit(0);

					break;
				}
			}
		}

	}

}
