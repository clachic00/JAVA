package version05;

public class PhoneCafeInfo extends PhoneInfor {

	String cafeName;
	String nickName;

	PhoneCafeInfo(String name, String phoneNumber, String addr, String email, String cafeName, String nickName) {
		super(name, phoneNumber, addr, email);

		this.cafeName = cafeName;
		this.nickName = nickName;

	}

	@Override
	public void showAllInfo() {

		showBasicInfo();

		System.out.println("동호회  : " + this.cafeName);
		System.out.println("닉네임  : " + this.nickName);

	}

}
