package phonenumber2;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumber {

	String name;
	String phoneNumber;
	String birthday;
	PhoneNumber array[] = new PhoneNumber[100];

	PhoneNumber(String n, String num) {
		name = n;
		phoneNumber = num;
		birthday = "000000";

	}

	PhoneNumber(String n, String p, String b) {
		name = n;
		phoneNumber = p;
		birthday = b;

	}

	int i = 0;

	void saveInfo(PhoneNumber info) {

		array[i] = info;

		i++;
	}

	PhoneNumber showInfo(int a) {

		PhoneNumber information = array[a];

		return information;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhoneNumber save = new PhoneNumber("", "", "");

		String n;
		String p;
		String b;
		int select = 0;
		int search = 0;
		while (true) {
			System.out.println("---------------");

			System.out.println("1.저장 2.검색 3.삭제");

			System.out.println("---------------");
			select = sc.nextInt();

			if (select == 1) {
				while (true) {
					System.out.println("이름, 연락처, 생일 입력");
					n = sc.next();
					p = sc.next();
					b = sc.next();

					PhoneNumber info = new PhoneNumber(n, p, b);

					save.saveInfo(info);

					System.out.println("계속하려면 1, 메뉴로 돌아가려면 0");

					select = sc.nextInt();

					if (select == 1) {
						continue;

					} else {
						break;
					}

				}
				continue;

			}

			if (select == 2) {
				System.out.println("번호를 입력해주세요");
				search = sc.nextInt();
				System.out.println(save.showInfo(search).toString());
				
//				System.out.println("이름 : " + save.showInfo(search).name + " 번호 : " + save.showInfo(search).phoneNumber
//						+ " 생일 : " + save.showInfo(search).birthday);

			} else if(select == 3) {
				
			}
			
			
		}
	}

	@Override
	public String toString() {
		return "PhoneNumber [name=" + name + ", phoneNumber=" + phoneNumber + ", birthday=" + birthday + ", array="
				+ Arrays.toString(array) + ", i=" + i + "]";
	}



}
