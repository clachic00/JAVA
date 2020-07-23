package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;
import board.model.BoardListModel;

// BoardDao �� ���� ��û�� �������� �ش��ϴ� �Խñ� ����� �о�� BoardListModel ��ü�� ����!!

/* [ListBoardService]: ��û�� ������ ��ȣ�� ���Ե� �޽��� ��� ���ϱ�
 - BoardDao Ŭ������ selectCount(), select() �޼��带 �̿��� 
	����ڰ� ��û�� �������� �ش��ϴ� �Խñ� ����� ���� ��,
	BoardListModel ��ü�� ����� ��Ƽ� ��õ�Ѵ�!!
*/
public class ListBoardService {

	private static ListBoardService instance = new ListBoardService();
	
	public static ListBoardService getInstance() {
		return instance;
	}
	
	//�� �������� ������ �� ����
	public static final int COUNT_PER_PAGE = 10;
	
	public BoardListModel getBoardList(int requestPageNumber) {
		if( requestPageNumber < 0 ) {
			throw new IllegalArgumentException("page number < 0 : "
				+ requestPageNumber);
		}
		
		BoardDao boardDao = BoardDao.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			//��ü �� ���� 
			int totalBoardCount = boardDao.selectCount(conn);
			
			// @@ ��ü �Խñ�=0 �̶��, BoardListModel ��ü ����
			if( totalBoardCount == 0 ) {
				return new BoardListModel();
			}
			
			//calculateTotalPageCount() �޼��� ȣ���ؼ�, ��ü ������ ���� ����
			int totalPageCount = calculateTotalPageCount(totalBoardCount);
			
			//��û�� ������ ��ȣ�� �̿��ؼ�, �о�� ���� ���� ��� �� �࿡ ���ϴ� board ����� ���Ѵ�.
			int firstRow = (requestPageNumber - 1) * COUNT_PER_PAGE + 1;
			int endRow = firstRow + COUNT_PER_PAGE - 1;
			
			if (endRow > totalBoardCount) {
				endRow = totalBoardCount;
			}
			
			// BoardDao.select() �޼��� �̿��ؼ�, ���� ��� �� �࿡ ���ϴ� Board ����� ���Ѵ�.
			List<Board> boardList = boardDao.select(conn, firstRow, endRow);
			
			// Board ���. ��û ������ ��ȣ, ��ü ������ ����,  ���� ��, �� ���� �̿��ؼ� BoardListModel ��ü�� ������ �� ����
			BoardListModel boardListView = new BoardListModel( boardList, requestPageNumber, totalPageCount, firstRow, endRow);
			return boardListView;
			
			
		} catch (SQLException e) {
			throw new RuntimeException("DB ����: "+e.getMessage(), e);
		} finally { JdbcUtil.close(conn);
		
		} //end try
		
	}
	
	// ��ü �Խñ� �����κ��� ��ü ������ ������ �����ִ� �޼���
	private int calculateTotalPageCount(int totalBoardCount) {
		if( totalBoardCount == 0 ) {
			return 0;
		}
		int pageCount = totalBoardCount / COUNT_PER_PAGE;
		if( totalBoardCount % COUNT_PER_PAGE > 0 ) {
			pageCount++;
		}
		return pageCount;
	}
}

