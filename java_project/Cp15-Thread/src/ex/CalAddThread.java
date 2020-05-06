package ex;

public class CalAddThread extends Thread {

	Calculator cal;

	public CalAddThread(Calculator c) {
		cal = c;
	}

	@Override
	public void run() {
		System.out.println(cal.add(2, 1));
		System.out.println(cal.add(4, 2));

	}

}
