<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ include file="/include/session.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<html>
<head>
<title>�� �б�</title>
</head>
<body>
	
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>����</td>
		<td>${board.title}</td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td>${board.write_name}</td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td><fmt:formatDate value="${board.writeday}" pattern="yyyy-MM-dd" /></td>
	</tr>
	<tr>
		<td>����</td>
		<td>
			<!-- 
				[pre]: �Է��� ������ �����̳� �ٹٲ� ���ڸ� ȭ�鿡 �״�� ������ش�!! 
				[out]: string�̳�, a �� ���� �±��� ���ڸ� html �±װ� �ƴ� ���ڷ� ����ϱ� ���� ���
			-->		
			<pre><c:out value="${board.content}" /></pre>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" style="padding: 5px;">
			<input type="button" value="�������"  onclick="location.href='list.jsp?p=${param.p}'"/>		
			<input type="button" value="�亯����"  onclick="location.href='replyForm.jsp?board_idx=${board.idx}&ref=${board.ref}&step=${board.step}&low=${board.low}&p=${param.p}'"/>
			<input type="button" value="����"  onclick="location.href='update.jsp?board_idx=${board.idx}&p=${param.p}'"/>
			<input type="button" value="����"  onclick="location.href='delete_ok.jsp?idx=${board.idx}'"/>
		</td>
	</tr>	
	</table>
	
</body>
</html>