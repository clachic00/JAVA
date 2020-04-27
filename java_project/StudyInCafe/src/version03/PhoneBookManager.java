package version03;

import java.util.Scanner;

public class PhoneBookManager {

	Scanner sc = new Scanner(System.in);
	
	PhoneInfor info = new PhoneInfor();
	PhoneInfor[] pBook = new PhoneInfor[100];
	int cnt;
	
	
	PhoneInfor createinstance(){
		
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("전화번호 입력해주세요");
		String phoneNumber = sc.nextLine();
		System.out.println("생일을 입력해주세요");
		String birthday = sc.nextLine();
		
		if (birthday==""||birthday.trim().isEmpty()) {
		
		
			info = new PhoneInfor(name, phoneNumber);
		
		} else {info = new PhoneInfor(name, phoneNumber, birthday);
		}
		
		
		return info;
		
	}
	
	void addInfo(PhoneInfor info) {
		
		pBook[cnt]=info;
		
		cnt++;
		
	}

	void addInfo() {
		
		pBook[cnt]=createinstance();
		
		cnt++;
		
	}	
	
	void ShowAllData() {
		
		for(int i = 0; i<cnt;i++) 
		pBook[i].showInfo();
		
		
	}
	
	void searchInfo () {
		
		System.out.println("이름으로 검색해주세요");
		String searchName = sc.nextLine();
		int searchIndex = -1;
		System.out.println("=================");
		for (int j = 0 ; j<cnt ; j++) {
			
			if(pBook[j].checkName(searchName)) {
					searchIndex = j;
				break;
			}
		}
		
		
			if(searchIndex < 0) {
				System.out.println("찾으시는 이름이 없습니다");
				
			
			} else {
				info.showInfo();
				
			}
			
			
			
		}

	void deleteInfo () {
		
		System.out.println("이름으로 검색해주세요");
		String searchName = sc.nextLine();
		int searchIndex = -1;
		System.out.println("=======================");
		for (int j = 0 ; j<cnt ; j++) {
			
			if(pBook[j].checkName(searchName)) {
					searchIndex = j;
				break;
			}
		}
		
		
			if(searchIndex < 0) {
				System.out.println("찾으시는 이름이 없습니다");
				
			
			} else {
				
				for(int deleteIndex = searchIndex; deleteIndex<cnt; deleteIndex++) {
				
					pBook[deleteIndex]=pBook[deleteIndex+1];
				
				if(deleteIndex == searchIndex ) {
					System.out.println("삭제되었습니다");
					break;
				}
				
				
			}	
				
				
				cnt--;
			
			
			
			
		}
	
	
	
	}
}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

