<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="exceptionType" value="${updateException.getClass().simpleName}" />

<html>
<head>
<title>���� ����</title>
</head>
<body>

	����:
	<c:choose>
		<c:when test="${exceptionType == 'BoardNotFoundException'}">
			������ �Խñ��� �������� �ʽ��ϴ�.
		</c:when>
		<c:when test="${exceptionType == 'InvalidPasswordException'}">
			��ȣ�� �߸� �Է��ϼ̽��ϴ�.
		</c:when>
	</c:choose>
	<br />
	<a href="<c:url value='list.jsp?p=${param.p}'/>">��Ϻ���</a>
	
</body>
</html>