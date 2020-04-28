package versionA5;

public class PhoneCompanyInfor extends PhoneInfor {


	String company;

	PhoneCompanyInfor(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);


		this.company = company;

	}

	@Override
	public void showData() {
		super.showInfo();


		System.out.println("회사 : " + this.company);

	}

}
