package board.service;

// ���� ��û ������ ���� (������ ���� idx ����)
public class DeleteRequest {
	private int idx;
	private int ref;
	private int step;
	private int low;		

	public int getIdx() { return idx; }
	public void setIdx(int idx) { this.idx = idx; }

	public int getRef() { return ref; }
	public void setRef(int ref) { this.ref = ref; }
	
	public int getStep() { return step; }
	public void setStep(int step) { this.step = step; }
	
	public int getLow() { return low; }
	public void setLow(int low) { this.low = low; }	
}