package review;

public class AdderThread extends Sum implements Runnable {
	int start, end;

	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public void run() {

		for (int i = start; i <= end; i++) {
			addNum(i);
			try {

				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("중간 합계 : " + getNum());

		}
	}

}




