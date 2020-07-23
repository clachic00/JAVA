<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="board.service.ReadBoardService"%>
<%@page import="board.service.BoardNotFoundException"%>
<%@page import="board.model.Board"%>

<%
	//[BoardService.readBoared() �޼��带 �̿�(������ idx�� �ش��ϴ� Board ��ü�� ����)�ؼ� �Խñ� �����͸� �о�� ��, read_view.jsp �� ������ ������]
	int board_idx = Integer.parseInt(request.getParameter("board_idx"));
	String viewPage = null;
	
	try {
		Board board = ReadBoardService.getInsteance().readBoard(board_idx);
		request.setAttribute("board", board);
		viewPage = "read_view.jsp";
		
	} catch (BoardNotFoundException ex) {
		viewPage = "board_not_found.jsp";
	}
%>

<jsp:forward page="<%=viewPage%>" />