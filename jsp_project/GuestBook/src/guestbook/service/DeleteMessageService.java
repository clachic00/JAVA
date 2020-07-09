package guestbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class DeleteMessageService {

	private DeleteMessageService() {}
	
	private static DeleteMessageService service = new DeleteMessageService();
	
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	MessageDao dao;
	
	public int deleteMessage(int mid, String pw) {
		 int resultCnt=0;
		 
		 Connection conn = null;
		 Message message= null;
		 
		

	 try {
		 
		 conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			message = dao.selectMessage(conn, mid);
		 
		 if(message == null) {
			 resultCnt =-1;
			 throw new Exception("삭제 할 메세지가 존재하지 않습니다.");
		 }
			
		 if(!message.getPw().equals(pw)) {
			 resultCnt=-2;
			 throw new Exception("비밀번호가 일치하지 않음.");
		 }
		 //삭제
		resultCnt = dao.deleteMessage(conn, mid);
		 
		 
		}catch(SQLException e){
			
			e.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			
		
			if(conn != null) {
				try {
					conn.close();
				
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}
		}
	 return resultCnt;

}
}
