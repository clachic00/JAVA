package board.model;

import java.sql.Timestamp;
import java.util.Date;

// [������� �Խñ� ���� ��û ������ �����Ѵ�]
public class WriteRequest {

	private String title;
	private String content;
	private int writer_idx;
	private String writer_id;
	private String writer_name;

	public WriteRequest(String title, String content, int writer_idx, String writer_id, String writer_name) {
		super();
		this.title = title;
		this.content = content;
		this.writer_idx = writer_idx;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
	}
	
	// ��û �����κ��� Board ��ü�� �����Ѵ�.
	/* toBoard() �޼���� WriteRequest ��ü�� ������ �����ͷκ���, Board ��ü�� �����ϴµ�, 
		�� �޼���� WriteBoardService Ŭ�������� BoardDao�� ������ Board ��ü�� ������ �� ���ȴ�.
	*/
	public Board toBoard() {
		return new Board(title, content, writer_idx, writer_id, writer_name);
	}

	public WriteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWriter_idx() {
		return writer_idx;
	}

	public void setWriter_idx(int writer_idx) {
		this.writer_idx = writer_idx;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	
	

	@Override
	public String toString() {
		return "WriteRequest [title=" + title + ", content=" + content + ", writer_idx=" + writer_idx + ", writer_id="
				+ writer_id + ", writer_name=" + writer_name + "]";
	}

}
