package version05;

public abstract class PhoneInfor implements Info {

	// private : 변수의 직접 참조를 막는다, 정보은닉
	String name; // 친구의 이름
	private String phoneNumber; // 친구의 전화 번호
	private String addr; // 친구의 주소
	private String email; // 친구의 이메일

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

//	void showAllInfo() {
//
//		showBasicInfo();
//
//	}

	// name 속성값과 전달받은 문자열을 비교해서 boolean값으로 반환

	boolean checkName(String name) {
		return this.name.equals(name);
	}

}



//2020.04.29
//Project ver 0.50
//PhoneBookManager 클래스의 인스턴스수가 최대 하나를 넘지 않도록 코드를
//변경.
//‘initerface’기반의 상수 표현을 바탕으로 메뉴 선택과 그에 따른 처리가, 이름에 부여된 상 수를 기반으로 진행되도록 변경.
//PhoneInfor 클래스의 구조에서 “interface”를 추가하여 “추상 클래스”로 구성해봅시다
//이 인터페이스에는 오버라이딩을 위한 메서드만 포한하는 인터페이스로 구성합니다.





