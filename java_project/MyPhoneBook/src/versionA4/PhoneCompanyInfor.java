package versionA4;

public class PhoneCompanyInfor extends PhoneInfor {

	String address;
	String email;
	String company;

	PhoneCompanyInfor(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber);

		this.address = address;
		this.email = email;
		this.company = company;

	}

	@Override
	void showData() {
		super.showInfo2();

		System.out.println("주소 : " + this.address);
		System.out.println("이메일 : " + this.email);
		System.out.println("회사 : " + this.company);

	}

}
