package ex;

public class ThreadMain2 {

	public static void main(String[] args) {


	// Runnable 을 구현하는  인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
	
	
	// 쓰레드 인스턴스 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		System.out.println("1부터 100까지의 합 "+(at1.getNum()+at2.getNum()));
		
		
		
	
	
//	for(int i=0; i<100; i++)
//	{
//		System.out.println("메인쓰레드가 실행 중입니다.");
//	}
	
	
	
	
	
	
	
	
	
	
	}

}
