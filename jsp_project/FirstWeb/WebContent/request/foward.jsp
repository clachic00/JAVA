<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String name = (String) request.getAttribute("username");
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style></style>
<title>Insert title here</title>
</head>
<body>

<h1>request 속성 공유 : <%= name %></h1>


</body>
</html>