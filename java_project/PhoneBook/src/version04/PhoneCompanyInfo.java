package version04;

public class PhoneCompanyInfo extends PhoneInfor {

	
	String company;		//회사
	String dept;			//부서
	String job;          //직급
	
	
	
		
	PhoneCompanyInfo(String name, String phoneNumber, String addr, String email, String company, String dept, String job) {
		super(name, phoneNumber, addr, email);
		// TODO Auto-generated constructor stub

	this.company = company;
	this.dept = dept;
	this.job = job;
	

	
	}




	@Override
	void showAllInfo() {
		
		super.showAllInfo();
		
		System.out.println("회사  : " + company);
		System.out.println("부서  : " + dept);
		System.out.println("직책  : " + job); 
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
