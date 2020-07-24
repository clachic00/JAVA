<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
<%-- <c:url value="css/default.css"/> --%>
<style>
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<a href="<c:url value="board/boardList.do"/>">home</a>
</body>
</html>
