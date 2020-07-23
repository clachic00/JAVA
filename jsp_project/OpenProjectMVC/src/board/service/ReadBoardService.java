package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// [�Խñ� �б� ��� ���� (BoardDao �� �̿��ؼ� �Խñ� �����͸� �о����, �Խñ��� ������ ��� ��ȸ�� ����)]

/* �Խñ� ��ȸ ȭ���� �����ֱ� ���� ���Ǵ� readBoard() �޼���� �Խñ� ����ȭ�鿡�� �Խñ� ������ �����ֱ� ���� ���Ǵ� getBoard() �޼��带 ������
 	�� ���� ������ ������ �Խñ� ����/������ ����ϱ� ���� Board ��ü�� ���Ѵ�.
*/ 	
public class ReadBoardService {
	
	private static ReadBoardService instance = new ReadBoardService();
	public static ReadBoardService getInsteance() {
		return instance;
	}
	private ReadBoardService() {
		
	}
	
	// �Խñ��� ��ȸ�ϰ�, ��ȸ���� �߰���Ű�� �޼���. ���������� selectBoard() ȣ�� (�� �� selectBoard()�� �ι�° �Ķ������ increaseCount�� ������ true�� ���������ν� ��ȸ���� ������Ŵ)
	public Board readBoard(int board_idx) throws BoardNotFoundException {
		return selectBoard(board_idx, true);
	}
	
	// @@ ���� �Խñ� ��ȸ ����� ������ �޼���
	private Board selectBoard(int board_idx, boolean increaseCount) throws BoardNotFoundException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			BoardDao boardDao = BoardDao.getInstance();
			//BoardDao�� �̿��ؼ� ������ idx�� Board�� ���Ѵ�.
			Board board = boardDao.selectById(conn, board_idx);
			
			// 1. �Խñ��� ���ٸ�, �ͼ��� �߻�
			if (board == null) {
				throw new BoardNotFoundException("�Խñ��� �������� ����: " + board_idx);
			}
			
			// 2. �Խñ��� �ִٸ�, ��ȸ�� ����. ȭ�鿡 ������ ��ȸ���� 1���� ��Ų�� ??			
			if (increaseCount) {
				boardDao.increaseReadCount(conn, board_idx);
				board.setReadnum(board.getReadnum() + 1);
			}
			return board;
			
		} catch (SQLException e) {
			throw new RuntimeException("DB ����: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	// �Խñ۸� ��ȸ�ϰ� ��ȸ���� ������������ �ʴ� �޼��� (����ȭ���� ������ ���� ��ȸ�� �����Ǹ� �ȵǹǷ�, false)
	public Board getBoard(int board_idx) throws BoardNotFoundException {
		return selectBoard(board_idx, false);
	}
		
}


