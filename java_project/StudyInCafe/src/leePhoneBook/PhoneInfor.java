package leePhoneBook;

public class PhoneInfor {

	   // private : 변수의 직접 참조를 막는다, 정보은닉
	   private String name; // 친구의 이름
	   private String phoneNumber; // 친구의 전화 번호
	   private String birthday; // 친구의 생일

	   PhoneInfor(){
	      
	   }


	   // 초기화를 위한 생성자
	   PhoneInfor(String name, String phoneNumber, String birthday) {
	      this.name = name;
	      this.phoneNumber = phoneNumber;
	      this.birthday = birthday;
	   }

	   PhoneInfor(String name, String phoneNumber) {
	      // this.name = name;
	      // this.phoneNumber = phoneNumber;
	      // this(name, phoneNumber, null);
	      this(name, phoneNumber, "입력값이 없습니다.");
	   }

	   void showInfo() {
	      System.out.println("이름 :" + this.name);
	      System.out.println("전화번호 : " + this.phoneNumber);
	      System.out.println("생년월일 : " + this.birthday);
	   }
	   
	   
	   boolean checkName(String name) {
	      boolean isTrue = false;
	         
	         isTrue = this.name.equals(name);
	         
	         return isTrue;
	      
	   }
	   
}