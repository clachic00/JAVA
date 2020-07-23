<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="board.model.BoardListModel" %>
<%@ page import="board.service.ListBoardService" %>

<%
	// [�Խñ� ��� ��ȸ ��û�� ó���ϴ� ��Ʈ�ѷ� JSP. ListBoardService.getBoardList() �޼��忡 �о�� ������ ��ȣ�� ��û�ϰ�, �� ����� BoardListModel ��ü�� list_view.jsp �� ����] 

	/* p �Ķ���ͷ� �о�� ������ ��ȣ�� ���� ������, ListArticleService Ŭ������ getBoardList() �޼��忡 �����Ѵ�.
		getBoardList() �޼���� ������ ��ȣ�� ���õ� �����͸� ������ BoardListModel ��ü�� �����ϸ�, BoardListModel ��ü�� list_view.jsp �� ����!!
	*/
	// p �Ķ���ͷκ��� �о�� ������ ��ȣ�� ���Ѵ�.
	String pageNumberString = request.getParameter("p");
	int pageNumber = 1;
	if (pageNumberString != null && pageNumberString.length() > 0) {
		pageNumber = Integer.parseInt(pageNumberString);
	}

	ListBoardService listSerivce = ListBoardService.getInstance();
	//ListSerivce.getBoardList()�� �̿��ؼ� ����ڰ� ��û�� �������� �ش��ϴ� boardListModel ��ü�� ���Ѵ�.	
	BoardListModel boardListModel = listSerivce.getBoardList(pageNumber);
	request.setAttribute("listModel", boardListModel);
	
	if (boardListModel.getTotalPageCount() > 0) {
		//������ ���� ��ȣ�� �� ��ȣ�� ����ؼ� ���Ѵ�.
		int beginPageNumber = (boardListModel.getRequestPage() - 1) / 10 * 10 + 1;
		int endPageNumber = beginPageNumber + 9;
		if (endPageNumber > boardListModel.getTotalPageCount()) {
			endPageNumber = boardListModel.getTotalPageCount();
		}
		// ������ ���� ��ȣ�� �� ��ȣ�� request ��ü�� �Ӽ����� �����Ѵ�.
		request.setAttribute("beginPage", beginPageNumber);
		request.setAttribute("endPage", endPageNumber);
	}
%>

<jsp:forward page="list_view.jsp" />
