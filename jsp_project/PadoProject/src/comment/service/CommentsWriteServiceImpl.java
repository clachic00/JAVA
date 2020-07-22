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

public class CommentsWriteServiceImpl implements Service{

	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		int bidx = 0;
		int cidx = 0;
		String memail = null;
		String comment = null;
		
		Connection conn = null;
		
		
		try {
			
			bidx = Integer.parseInt(request.getParameter("bidx"));
			cidx = Integer.parseInt(request.getParameter("cidx"));
			memail = request.getParameter("memail");
			comment =  request.getParameter("comment");
					
			
			
			
			
			Comments comments = new Comments();
			comments.setBidx(bidx);
			comments.setCidx(cidx);
			comments.setComment(comment);
			comments.setMemail(memail);
			
			
			System.out.println(comments.getBidx());
			System.out.println(comments.getCidx());
			System.out.println(comments.getComment());
			System.out.println(comments.getMemail());
			System.out.println(comments.getCregdate());
			
			
			
			
			conn= ConnectionProvider.getConnection();
			
			dao= MemberDao.getInstance();
		
			resultCnt=dao.writeComment(conn, comments);
			
			request.setAttribute("comments", comments);
			request.setAttribute("result", resultCnt);
			
			
			

			
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
