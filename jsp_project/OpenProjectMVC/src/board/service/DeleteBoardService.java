package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// ���� ��� ����

// BoardCheckHelper Ŭ������ �̿��Ͽ�, �Խñ� ���� ���ο� ��ȣ ��ġ ���θ� Ȯ�� �ϰ�, ��ȣ�� ��ġ�ϸ� BoardDao.delete()�� �̿��ؼ� ����!!
public class DeleteBoardService {
	
	private static DeleteBoardService instance = new DeleteBoardService();
	public static DeleteBoardService getInstance() {
		return instance;
	}
	private DeleteBoardService() {

	}

	public void deleteBoard(DeleteRequest deleteRequest) throws BoardNotFoundException {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
				//BoardCheckHelper checkHelper = new BoardCheckHelper();
				// ������ �Խñ��� �����ϴ����� ���ο� ��ȣ�� ��ġ�ϴ��� Ȯ��
				//checkHelper.checkExistsAndPassword(conn, deleteRequest.getBoardId(), deleteRequest.getPassword());
	
				BoardDao boardDao = BoardDao.getInstance();
				boardDao.delete(conn, deleteRequest.getIdx());
			conn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		/*} catch (BoardNotFoundException e) {
			JdbcUtil.rollback(conn);
			throw e;*/
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					
				}
			}
			JdbcUtil.close(conn);
		}
		
	}
}
