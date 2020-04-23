package ex;

public class OverridingTest {

	public static void main(String[] args) {

		// 다형성:상위클래스 타입의 참조변수에 하위클래스 인스턴스 참조
		Speaker sp = new BaseEnSpeaker();
		// 참조변수 sp는
		// BaseEnSpeaker 인스턴스 멤버중 
		// speaker가 가지던 멤버만 사용한다.
		
		
		sp.showCurrentState();
//		sp.setBaseRate(100);
		
		
		
		
		
		
		
		System.out.println("========================");
		
		BaseEnSpeaker be = new BaseEnSpeaker();

		be.setVolume(10);
		be.setBaseRate(20);

		be.showCurrentState();

		System.out.println(be);
	}

}
