package toStringPractice;

public class Friend {

	String myName;
	
	Friend(String name) {

	myName = name;
	
	}
	
	
	
	
//	오버라이딩
//	public String toString() {
//		return "제 이름은" + this.myName + "입니다.";
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "제 이름은"+ myName;
	}




	public static void main(String[] args) {
	
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");
		
		System.out.println(f1.toString());
		System.out.println(f1);
		System.out.println(f2.toString());
		System.out.println(f2);
		
	}
	
	
	
	
	
	
}
