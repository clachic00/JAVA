package PhoneBookver3;



// 우리는 친구의 전화번호 정보를 기초로 추가정보를 저장해서 관리하는 프로그램을 만들고자 합니다. 
// 프로그램 개발 시 요구사항
// 1. 다음 두 클래스를 추가로 삽입. 상속 구조로 구성 해보세요. PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가 하세요. 
// 상속을 위한 추상클래스 또는 인터페이스를 정의해서 구조화 시켜주세요.

//  PhoneUnivInfor
//  이름 name String
//  전화번호 phoneNumber String
//  주소 address String
//  이메일 email String
//  전공 major String
//  학년 year String

//  PhoneCompaanyInfor
//  이름 name String
//  전화번호 phoneNumber String
//  이메일 email String
//  회사 company String

// 2. 친구의 저장 정보의 개수는 100개로 하고, 저장 방식은 배열 또는 컬레게션의 ArrayList 클래스를 사용하세요.
// 3. 기능 : 정보 입력, 정보 삭제, 정보 전체보기, 종료, 수정
// 4. [프로그램의 흐름]
//  1. 입력 --> 1. 일반 2. 대학 3. 회사 4. 동호회 --> 입력 형태로 구성
// 5. 메뉴 입력 시 예외 처리해주세요. 
// 6. 인터페이스의 상수타입을 사용해서 메뉴를 구성해주세요. 
// 7. 사용자에게 보여지는 콘솔에서 메뉴 표현하는 UI는 형식에 상관없이 작성해도 됩니다.


public class PhoneInfo {

	String name;
	String phoneNumber; 
	String email;


	PhoneInfo(String name, String phoneNumber, String email){
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
			
	}


	public PhoneInfo() {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
