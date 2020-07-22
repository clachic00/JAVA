<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style></style>
<title>Insert title here</title>
</head>
<body>

	<table class="table">
			<tr>
				<th>cidx</th>
				<th>bidx</th>
				<th>아이디</th>
				<th>댓글</th>
				
				<th>사진</th>
				<th>관리</th>
			</tr>
			
		<c:if test="${not empty listView.memberList }"> <!--MemberListServiceImpl.java에 있다 ListView -->
		<c:forEach items="${listView.memberList}" var="member">
			<tr>
				<td>${comments.cidx}</td>
				<td>${comments.bidx}</td>
				<td>${session.memail}</td>
				<td>${comments.comment}</td>
		
		
		
				<%-- <a href="memberEditForm.do?midx=${}">수정</a> 
				| 
				<a href="javascript:memberDel(${})">삭제</a></td> --%>
				
				
				
				
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty listView.memberList }">
			<tr>
				<th>조회된 회원이 없습니다.</th>
			</tr>
		</c:if>





</body>
</html>