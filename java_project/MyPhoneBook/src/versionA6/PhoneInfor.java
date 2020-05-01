package versionA6;

public abstract class PhoneInfor implements Info {

	private String name; // 친구의 이름

	String getName() {
		return name;
	}

	private String phoneNumber; // 친구의 전화 번호

	private String address; // 친구의 주소

	private String email; // 친구의 이메일

	PhoneInfor(String name, String phoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	// 다릍 클래스에 공유하기 위한 생일제외 메서드 생성
	void showInfo() {

		System.out.println("이름 : " + this.name);
		System.out.println("번호 : " + this.phoneNumber);
		System.out.println("주소 : " + this.address);
		System.out.println("이메일 : " + this.email);

	}

//	public void showData() {
//		showInfo();
//		System.out.println("생일 : " + this.birthday);
//	}

	boolean checkName(String name) {

		boolean isTrue = this.name.equals(name);

		return isTrue;
	}

}