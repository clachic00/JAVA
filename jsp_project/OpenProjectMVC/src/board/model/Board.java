package board.model;

import java.sql.Timestamp;
import java.util.Date;

//[Board] Ŭ����: Board ���̺� Į���� ���εǴ� ������Ƽ ����� ���� �ִ�.
public class Board {

	private int idx;
	private String title;
	private String content;
	private int readnum;
	private Timestamp writedate;
	private int ref;
	private int step;
	private int low;
	private int isdel;
	private int writer_idx;
	private String writer_id;
	private String writer_name;
	
	public Board(int idx, String title, String content, int readnum, Timestamp writedate, int ref, int step, int low,
			int isdel, int writer_idx, String writer_id, String writer_name) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.readnum = readnum;
		this.writedate = writedate;
		this.ref = ref;
		this.step = step;
		this.low = low;
		this.isdel = isdel;
		this.writer_idx = writer_idx;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
	}
	
	public Board(String title, String content, int writer_idx, String writer_id, String writer_name) {
		this.title = title;
		this.content = content;
		this.writer_idx = writer_idx;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
	}

	public Board() {}

	
	
	
	
	public int getIdx() {
		return idx;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getReadnum() {
		return readnum;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public int getRef() {
		return ref;
	}

	public int getStep() {
		return step;
	}

	public int getLow() {
		return low;
	}

	public int getIsdel() {
		return isdel;
	}

	public int getWriter_idx() {
		return writer_idx;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public Date getTimeStampToDate() {
		return new Date(writedate.getTime());
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", title=" + title + ", content=" + content + ", readnum=" + readnum
				+ ", writedate=" + writedate + ", ref=" + ref + ", step=" + step + ", low=" + low + ", isdel=" + isdel
				+ ", writer_idx=" + writer_idx + ", writer_id=" + writer_id + ", writer_name=" + writer_name + "]";
	}
	
	

			
	
	// [hasPassword()]: ���� �޽����� ��ȣ�� �����Ǿ� �ִ��� Ȯ�����ִ� �޼����, DeleteMessageService Ŭ�������� ���� ����� ������ �� ���
	/*public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}*/
}
