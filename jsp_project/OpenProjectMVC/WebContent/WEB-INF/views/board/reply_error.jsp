<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="exceptionType" value="${replyException.getClass().simpleName}" />

<html>
<head>
<title>�亯 ����</title>
</head>
<body>

	����:
	<c:choose>
		<c:when test="${exceptionType == 'BoardNotFoundException'}">
			�亯�� ����� �Խñ��� �������� �ʽ��ϴ�.
		</c:when>
	</c:choose>
	<br />
	<input type="button" value="��Ϻ���"  onclick="location.href='list.jsp?p=${param.p}'"/>
	
</body>
</html>