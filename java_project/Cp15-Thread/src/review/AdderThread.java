package review;

public class AdderThread extends Sum implements Runnable {
	int start, end;
	public AdderThread(int s, int e)
	{
	start=s; end=e;
	}
	public void run()
	{
	for(int i=start; i<=end; i++) addNum(i);
	}
}
