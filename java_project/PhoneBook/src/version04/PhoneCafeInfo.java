package version04;



public class PhoneCafeInfo extends PhoneInfor {
	
		
	String cafeName;
	String nickName;
	
	
	
	
	PhoneCafeInfo(String name, String phoneNumber, String addr, String email, String cafeName, String nickName ) {
		super(name, phoneNumber, addr, email);
		
		
		this.cafeName = cafeName;
		this.nickName = nickName;
			
	}




	@Override
	void showAllInfo() {
	
		super.showAllInfo();
		
		System.out.println("동호회  : " + this.cafeName);
		System.out.println("닉네임  : " + this.nickName); 
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
