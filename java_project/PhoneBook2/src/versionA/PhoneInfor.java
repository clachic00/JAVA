package versionA;

public class PhoneInfor {

	private String name; // 친구의 이름
	private String phoneNumber; // 친구의 전화 번호
	private String birthday; // 친구의 생일

	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	PhoneInfor(String name, String phoneNumber) {

		this(name, phoneNumber, "입력값이 없습니다.");
	}

	void showInfo() {

		System.out.println("이름 : " + this.name);
		System.out.println("번호 : " + this.phoneNumber);
		System.out.println("생일 : " + this.birthday);

	}

	boolean checkName(String name) {

		boolean isTrue = this.name.equals(name);

		return isTrue;
	}

}