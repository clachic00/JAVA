<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String userName = (String) session.getAttribute("username");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<H1>안녕하세요</H1>
<%
	//스크립트릿 영역 : java 코드 작성 앞으로 사용않
	Date now = new Date();
%>


	<!-- 표현식 -->
	<%= now %>
	
	사용자 이름 : 	<%= userName %>
	
		
		<%
		session.setAttribute("username", "KING");
		%>
		
		<br>
		
			<a href="session/sessionView01.jsp">session view</a>
		
		
		
		
	
</body>
</html>