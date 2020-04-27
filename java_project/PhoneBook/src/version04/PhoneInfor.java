package version04;


public class PhoneInfor {
	
	//private : 변수의 직접 참조를 막는다, 정보은닉
	String name; 			// 친구의 이름
	private String phoneNumber; 	// 친구의 전화 번호
	private String addr; 			// 친구의 주소
	private String email;			// 친구의 이메일

	// 초기화를 위한 생성자
	PhoneInfor(String name, String phoneNumber, String addr, String email) {
	
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}
	
	
	void showBasicInfo() {
		System.out.println("이름 :" + this.name);
		System.out.println("전화번호 : " + this.phoneNumber);
		System.out.println("주소  : " + this.addr);
		System.out.println("이메일  : " + this.email);

	}

	void showAllInfo() {
		
		showBasicInfo();
		
		
	}
	

	
	
	
	//name 속성값과 전달받은 문자열을 비교해서 boolean값으로 반환
	boolean checkName(String name) {
		return this.name.equals(name);
	}
	
	
	
	
}