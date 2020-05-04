package ex;

public class TestMain {

	public static void main(String[] args) {

		
		Singleton s = Singleton.getInSingleton();
		s.print();
		
		Member member = new Member();
		
		System.out.println(member.getId());
		
		
	}

}
