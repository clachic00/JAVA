package versionA;

import java.util.Scanner;



public class PhoneBookManager {

	Scanner sc = new Scanner(System.in);
	int cnt;
	PhoneInfor pBooks[] = new PhoneInfor[100];

	void addinfo(PhoneInfor info) {
		
		pBooks[cnt]=info;
		
		cnt++;
	}

	PhoneInfor createInstance() {

		PhoneInfor info = null;

		System.out.println("이름을 입력해주세요");

		String name = sc.nextLine();

		System.out.println("번호를 입력해주세요");

		String phoneNumber = sc.nextLine();

		System.out.println("생일을 입력해주세요");

		String birthday = sc.nextLine();

		if (birthday == null || birthday.trim().isEmpty()) {

			info = new PhoneInfor(name, phoneNumber);
		} else {
			info = new PhoneInfor(name, phoneNumber, birthday);
		}

		return info;
	}

	void searchInfo(){
	System.out.println("이름으로 검색해주세요");
		String name= sc.nextLine();
	
		int searchIndex= -1;
		for(int i =0;  i <cnt;i++) {
		
			System.out.println(pBooks[i].name.equals(name));
		
			if(pBooks[i].name.equals(name)) {
				searchIndex = i;
				break;
			}
			
		}
		System.out.println(searchIndex);
		if(searchIndex<0) {
			System.out.println("입력하신 정보가 없습니다.");
		} else {
			pBooks[searchIndex].showInfo();
		}
		
	
	}
	
	
	
	void showAllData(){
		for (int i = 0; i < cnt; i++) {
			pBooks[i].showInfo();
			System.out.println("========================");
		}
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}





