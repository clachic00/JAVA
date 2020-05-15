package review;

public class Sum extends Thread{

	int num;
	public Sum() { num=0; }
	public void addNum(int n) { num+=n; }
	public int getNum() { return num; }
	
	
}
