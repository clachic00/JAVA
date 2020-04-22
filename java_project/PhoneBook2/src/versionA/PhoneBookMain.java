package versionA;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		
		PhoneInfor info = manager.createInstance();
		manager.addinfo(info);
		manager.showAllData();
		manager.searchInfo();
		
		
		
	}

}
