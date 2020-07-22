package comment.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Comments;
import member.model.Member;
import service.Service;

public class CommentsFormServiceImpl implements Service{

	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
	

			int bidx = Integer.parseInt(request.getParameter("bidx"));
			System.out.println("2"+bidx);

			

		request.setAttribute("bidx", bidx);
		
		
		return "/WEB-INF/views/comment/commentForm.jsp";
		
		
		
		
		
		
	}
	
	
}
