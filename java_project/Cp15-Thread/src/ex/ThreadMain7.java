package ex;

public class ThreadMain7 {

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		CalAddThread cat = new CalAddThread(cal);

		CalMinThread cmt = new CalMinThread(cal);

		cat.start();
		cmt.start();

		try {
			cat.join();
			cmt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cal.showOpCnt();

	}

}
