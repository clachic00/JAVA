package version05;

public class PhoneUnivInfo extends PhoneInfor {

	String major; // 친구의 전공
	String grade; // 친구의 학년

	PhoneUnivInfo(String name, String phoneNumber, String addr, String email, String major, String grade) {
		super(name, phoneNumber, addr, email);

		this.major = major;
		this.grade = grade;

	}

	@Override
	public void showAllInfo() {

		showBasicInfo();

		System.out.println("전공  : " + this.major);
		System.out.println("학년  : " + this.grade);

	}

}
