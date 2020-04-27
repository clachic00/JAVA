package version04;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		while (true) {
	
		Menu.showMenu();
			
			int selectNum = sc.nextInt();
			
			sc.nextLine();
			
			
			switch(selectNum) {
			case 1:
//				PhoneInfor info = manager.createInstance();
//				manager.addInfo(info);
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
