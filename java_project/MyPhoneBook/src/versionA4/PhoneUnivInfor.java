package versionA4;

public class PhoneUnivInfor extends PhoneInfor {

	String address;
	String email;
	String major;
	int year;

	PhoneUnivInfor(String name, String phoneNumber, String address, String email, String major, int year) {
		super(name, phoneNumber);

		this.address = address;
		this.email = email;
		this.major = major;
		this.year = year;

	}

	@Override
	void showData() {
		super.showInfo2();

		System.out.println("주소 : " + this.address);
		System.out.println("이메일 : " + this.email);
		System.out.println("전공 : " + this.major);
		System.out.println("학년 : " + this.year);

	}

}
