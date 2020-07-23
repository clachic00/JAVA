<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="board.service.ReplyBoardService"%>
<%@ page import="board.model.Board"%>

<%
	// ReplyBoardService Ŭ������ reply() �޼��带 �̿��ؼ� �亯 �� ���
	request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="replyingRequest" class="board.service.ReplyingRequest" />
<jsp:setProperty name="replyingRequest" property="*" />

<%
	String viewPage = null;

	try {
		Board postedBoard = ReplyBoardService.getInstance().reply(replyingRequest);
		request.setAttribute("postedBoard", postedBoard);
		viewPage = "reply_success.jsp";
	} catch (Exception ex) {
		viewPage = "reply_error.jsp";
		request.setAttribute("replyException", ex);
	}
%>

<jsp:forward page="<%=viewPage%>" />