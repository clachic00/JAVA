package versionA6;

public class PhoneCafeInfor extends PhoneInfor {

	String cafeName;
	String nickName;

	PhoneCafeInfor(String name, String phoneNumber, String address, String email, String cafeName, String nickName) {
		super(name, phoneNumber, address, email);

		this.cafeName = cafeName;
		this.nickName = nickName;

	}

	@Override
	public void showData() {
		super.showInfo();

		System.out.println("동호회 : " + this.cafeName);
		System.out.println("닉네임 : " + this.nickName);

	}

}