package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// �Խñ� ���� ��� ����
public class UpdateBoardService {
	private static UpdateBoardService instance = new UpdateBoardService();

	public static UpdateBoardService getInstance() {
		return instance;
	}

	private UpdateBoardService() {

	}

	public Board update(UpdateRequest updateRequest) throws BoardNotFoundException {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
				//BoardCheckHelper checkHelper = new BoardCheckHelper();
				// �Խñ� ���� ���ο� ��ȣ�� ��ġ�ϴ� ���� Ȯ��
				//checkHelper.checkExists(conn, updateRequest.getIdx());
	
				// UpdateRequest�� ���� Board ����
				Board updatedBoard = new Board();
				updatedBoard.setIdx(updateRequest.getIdx());
				updatedBoard.setTitle(updateRequest.getTitle());
				updatedBoard.setContent(updateRequest.getContent());
	
				BoardDao boardDao = BoardDao.getInstance();
				int updateCount = boardDao.update(conn, updatedBoard);			
	
				if (updateCount == 0) {
					throw new BoardNotFoundException("�Խñ��� �������� ����: "+ updateRequest.getIdx());
				}
				
				// ������ Board ��ü ����
				Board board = boardDao.selectById(conn, updateRequest.getIdx());
			conn.commit();
			
			return board;

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException("DB ����: " + e.getMessage(), e);
		} catch (BoardNotFoundException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					
				}
				JdbcUtil.close(conn);
			}
		}	//end try
		
	}
}
