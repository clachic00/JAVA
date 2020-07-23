package board.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// [�Խñ� ��� ȭ���� �����ϴ� �� �ʿ��� ������ ����!! �Խñ�(Board) ���, ��û ������ ��ȣ, ��ü ������ ���� ���� ������ ����]

// [BoardListModel]: ��û�� ������ ��ȣ, ��û�� �������� �޽��� ���, ��ü �޽��� ����, ������ ����, ������ �� ������ �޽��� ���� ���� ������ ��� Ŭ����
public class BoardListModel {

	private List<Board> boardList;
	private int requestPage;
	private int totalPageCount;
	private int startRow;	
	private int endRow;
	
	/* <������> 
	 - �޽��� ���(boardList), �޽��� ��ü ����(totalPageCount), ��û ������ ��ȣ(requestPage) 
	   ��ü �޽��� �߿��� ���� �޽��� ����� ���� ��� �� ���� ���޹޴´�. 
	*/
	public BoardListModel() {
		this(Collections.<Board> emptyList(), 0, 0, 0, 0);
	}

	public BoardListModel(List<Board> boardList, int requestPageNumber, int totalPageCount, int startRow, int endRow) {
		this.boardList = boardList;
		this.requestPage = requestPageNumber;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public boolean isHasBoard() {
		return !boardList.isEmpty();
	}

	public int getRequestPage() {
		return requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}	
	
}

