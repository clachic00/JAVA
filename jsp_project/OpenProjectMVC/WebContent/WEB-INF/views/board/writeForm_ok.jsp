<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="board.service.BoardWriteService" %>
<%@ page import="board.model.Board" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	// [������� ��û���� ����, WritingRequest ��ü�� ������ ��, WriteBoardService�� WritingRequest ��ü�� �����ؼ� �Խñ� ���⸦ ����]
	request.setCharacterEncoding("euc-kr");
%>

<!-- �۾��� ��û ������ ���� WritingRequest ��ü ���� -->
<jsp:useBean id="writingRequest" class="board.service.WritingRequest" />
<jsp:setProperty name="writingRequest" property="*" />

<%
	// WriteBoardService.write()�� WritngRequest ��ü ����
	Board writeBoard = BoardWriteService.getInstance().write(writingRequest);
	request.setAttribute("writeBoard", writeBoard);
%>

<script>
	parent.location.href="list.jsp";
</script>

