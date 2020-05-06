package ex;

public class CalMinThread extends Thread {

	Calculator cal;

	public CalMinThread(Calculator c) {

		cal = c;

	}

	@Override
	public void run() {
		System.out.println(cal.min(2, 1));
		System.out.println(cal.min(4, 2));

	}

}
