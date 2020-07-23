package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// [�亯 ���� ���� ���� (�亯�̶�� �������� ref,step,low�� �޾Ƽ� db���� ���� ref �߿��� �ڱ⺸�� ū step������ 1�� ������Ų��!!)]
/*  1. �亯 �� �θ���� �ִ��� üũ (������ �ͼ��� �߻�)
    2. �亯 ���� �ϱ� �� update (db���� ���� ref �� �ڱ⺸�� ū step�� step ���� 1 ������Ų��.)
    3. �亯 ���� (�޾ƿ� �������� step+1, low+1 �� ���� ����)
 */
public class ReplyBoardService {
	
	private static ReplyBoardService instance = new ReplyBoardService();
	public static ReplyBoardService getInstance() {
		return instance;
	}
	private ReplyBoardService() {
	}


	public Board reply(ReplyingRequest replyingRequest) throws BoardNotFoundException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
				BoardDao boardDao = BoardDao.getInstance();
				//[1] �亯 �� �θ�� �ִ��� üũ
				//�θ�� Board ��ü ����
				Board parent = boardDao.selectById(conn, replyingRequest.getParentBoard_idx());
				
				try {
					checkParent(parent, replyingRequest.getParentBoard_idx());
					
				// @@ �亯 �� �θ���� ��� �ͼ����� �߻��Ǹ�, Ʈ������� �ѹ��ϰ� �ش� �ͼ����� ��߻���Ŵ
				} catch (Exception e) {
					JdbcUtil.rollback(conn);
					// �θ� ���� ���ٸ� BoardNotFoundException
					if (e instanceof BoardNotFoundException) {
						throw (BoardNotFoundException) e;
					}
				} // end try 2 
				
				//[2] �亯 ���� �ϱ� �� update
//System.out.println("replyingRequest.getStep(): "+ replyingRequest.getStep());				
//System.out.println("replyingRequest.getRef(): "+ replyingRequest.getRef());

				boardDao.reply_before_update(conn, replyingRequest.getStep(), replyingRequest.getRef());
//System.out.println("reply_before_update ����Ϸ�");

				//[3] �亯 ����
				Board board = new Board();
				
				board.setTitle(replyingRequest.getTitle());
				board.setContent(replyingRequest.getContent());
				board.setRef(replyingRequest.getRef());
				board.setStep(replyingRequest.getStep()+1);
				board.setLow(replyingRequest.getLow()+1);
				board.setWrite_id(replyingRequest.getWrite_id());
				board.setWrite_name(replyingRequest.getWrite_name());
				board.setWriteday(new Date());			
				
				int board_idx = boardDao.reply_insert(conn, board);
	
				if (board_idx == -1) {
					throw new RuntimeException("DB ���� ����: " + board_idx);
				}
			conn.commit();
			
			board.setIdx(board_idx);
			return board;
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException("DB ����: " + e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					
				}
			}
			JdbcUtil.close(conn);
		} // end try1
		
	}

	private void checkParent(Board parent, int parentBoard_idx) throws BoardNotFoundException {
		if (parent == null) {
			throw new BoardNotFoundException("�θ���� �������� ����: " + parentBoard_idx);
		}
	}

}
