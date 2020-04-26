package leePhoneBook;

public class PhoneBookMain {
	   public static void main(String[] args) {
	      PhoneBookManager manager = new PhoneBookManager();

	      while (true) {

	         Menu.showMenu();
	         int selectNum = manager.sc.nextInt();
	         manager.sc.nextLine();
	         switch (selectNum) {
	         case 1:
	            manager.addInfo();
	            break;
	         case 2:
	            manager.searchInfo();
	            break;
	         case 3:
	            
	            manager.deleteData();
	            break;
	         case 4:
	            manager.showAllData();
	            break;
	         case 5:
	            System.exit(0);
	            //return ;
	         }

	      }

	   }

	}