<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	// ���� ��û�� DeleteBoardService�� ����
	// ���� ��û ������ ���� DeleteRequest ��ü�� ������ ��, DeleteBoardService�� delete() �޼��带 �����ؼ� ���� ��û�� ó���Ѵ�. 
	request.setCharacterEncoding("euc-kr");
%>

<%@page import="board.service.DeleteBoardService"%>

<jsp:useBean id="deleteRequest" class="board.service.DeleteRequest" />
<jsp:setProperty name="deleteRequest" property="*" />

<%
	String viewPage = null;

	try {
		DeleteBoardService.getInstance().deleteBoard(deleteRequest);
		viewPage = "delete_success.jsp";
	} catch (Exception ex) {
		request.setAttribute("deleteException", ex);
		viewPage = "delete_error.jsp";
	}
%>

<jsp:forward page="<%=viewPage%>" />