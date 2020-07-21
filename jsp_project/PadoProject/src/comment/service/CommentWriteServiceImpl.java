package comment.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Comments;
import member.model.Member;
import service.Service;

public class CommentWriteServiceImpl implements Service{

	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		int bidx = 0;
		String memail = null;
		String comment = null;
		
		Connection conn = null;
		
		
		try {
			
			Comments comments = new Comments();
			
			conn= ConnectionProvider.getConnection();
			
			dao= MemberDao.getInstance();
			
			resultCnt=dao.writeComment(conn, comments);
			
			request.setAttribute("comments", comments);
			request.setAttribute("result", resultCnt);
			
			
			System.out.println(comments.getBidx());
			System.out.println(comments.getCidx());
			System.out.println(comments.getComment());
			System.out.println(comments.getCregdate());

			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
			
		
		return "/WEB-INF/views/comment/commentWrite.jsp";
	}
	
	
	
}
