<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/include/session.jsp" %>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	// [list.jsp�κ��� ���޹��� BoardListModel ��ü�� �̿��ؼ� ��� ȭ���� ����]

	/* list.jsp�κ��� ���޹��� ������(boardListModel, beginPage, endPage) �� �̿��ؼ� ��� ȭ���� �����Ѵ�. */
	response.setHeader("Pargma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� ���</title>
</head>
<body>

	<table border="1" cellpadding="0" cellspacing="0">
		<c:if test="${listModel.totalPageCount > 0}">
			<tr>
				<td colspan="5">${listModel.startRow}-${listModel.endRow}
					[${listModel.requestPage}/${listModel.totalPageCount}]</td>
			</tr>
		</c:if>

		<tr align="center">
			<td>No</td>
			<td>����</td>
			<td>�ۼ���</td>
			<td>�ۼ���</td>
			<td>��ȸ��</td>
		</tr>
		
		<!-- @@ [(swich-case-default)�� ����]: �������� ó���� �� ��� -->
		<c:choose>
			<c:when test="${listModel.hasBoard == false}">
				<tr>
					<td colspan="5">�Խñ��� �����ϴ�.</td>
				</tr>
			</c:when>
	
			<c:otherwise>
				<c:forEach var="board" items="${listModel.boardList}">
					<tr>
						<td>
							${board.idx}
						</td>
						<td>
							<!-- �亯 ���̶��, ��ø ������ ���� ȭ��ǥ ��� -->
							<c:if test="${board.low > 0}">
								<c:forEach begin="1" end="${board.low}">-</c:forEach>&gt;
							</c:if> 
				
							<!-- ���� �� �б� ������ ��ũ (jsp ���� ���� ���� ����) -->
							<c:set var="query"  value="board_idx=${board.idx}&p=${listModel.requestPage}" />
								<a href="<c:url value="read.jsp?${query}"/>"> ${board.title}</a>
						</td>
						<td>${board.write_name}</td>
						<td>${board.writeday}</td>
						<td>${board.readnum}</td>
					</tr>
				</c:forEach>
				
				<!-- ����¡ -->
				<tr>
					<td colspan="5" align="center">
						<c:if test="${beginPage > 10}">
							<a href="<c:url value="list.jsp?p=${beginPage-1}"/>">����</a>
						</c:if> 
						<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
							<a href="<c:url value="list.jsp?p=${pno}" />">[${pno}]</a>
						</c:forEach> 
						<c:if test="${endPage < listModel.totalPageCount}">
							<a href="<c:url value="list.jsp?p=${endPage + 1}"/>">����</a>
						</c:if>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>		
		
		
		<tr>
			<td colspan="5">
				<a href="writeForm.jsp"><input type="button" value="�۾���"></a>
			</td>
		</tr>
	</table>
	
	<br>			
	<table>
	<tr>
		<td>
			<input type="button" value="��������" onclick="location.href='<%= request.getContextPath() %>/member/loginForm.jsp'">
		</td>
	</tr>
	</table>		
	
</body>
</html>