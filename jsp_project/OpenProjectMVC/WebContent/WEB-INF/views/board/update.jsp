<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="board.service.ReadBoardService" %>
<%@ page import="board.model.Board" %>
<%@ page import="board.service.BoardNotFoundException" %>

<%
	// ���� ������ ������ Board ��ü�� ���� ��, update_form_view.jsp �� �̵�
	String viewPage = null;

	try {
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		Board board = ReadBoardService.getInsteance().getBoard(board_idx);
		viewPage = "updateForm.jsp";
		request.setAttribute("board", board);
	
	} catch (BoardNotFoundException ex) {
		viewPage = "board_not_found.jsp";
	}
%>

<jsp:forward page="<%= viewPage %>" />