<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="board.service.UpdateBoardService"%>
<%@ page import="board.model.Board"%>

<%
	// �� ���� ��û�� UpdateBoardService �� �����ؼ� �� ���� ��û�� ó����
	// UpdateRequest ��ü�� ������ ��, UpdateBoardService Ŭ������ �̿��ؼ� ���� ��û�� ó���Ѵ�.
	request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="updateRequest"	class="board.service.UpdateRequest" />
<jsp:setProperty name="updateRequest" property="*" />

<%
	String viewPage = null;

	try {
		Board board = UpdateBoardService.getInstance().update(updateRequest);
		request.setAttribute("updatedBoard", board);
		viewPage = "update_success.jsp";		
	
	} catch (Exception ex) {
		request.setAttribute("updateException", ex);
		viewPage = "update_error.jsp";
	}
%>

<jsp:forward page="<%=viewPage%>" />