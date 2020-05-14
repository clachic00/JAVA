package review;

import ex.ShowThread;

public class ThreadUnderstand {

	public static void main(String[] args) {
		ShowThread st1=new ShowThread("멋진 쓰레드");
		ShowThread st2=new ShowThread("예쁜 쓰레드");
		st1.start();
		st2.start();
	}

}
