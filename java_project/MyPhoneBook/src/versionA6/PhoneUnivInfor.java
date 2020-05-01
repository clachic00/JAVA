package versionA6;

public class PhoneUnivInfor extends PhoneInfor {

	String major;
	int year;

	PhoneUnivInfor(String name, String phoneNumber, String address, String email, String major, int year) {
		super(name, phoneNumber, address, email);

		this.major = major;
		this.year = year;

	}

	@Override
	public void showData() {
		super.showInfo();

		System.out.println("전공 : " + this.major);
		System.out.println("학년 : " + this.year);

	}

}
