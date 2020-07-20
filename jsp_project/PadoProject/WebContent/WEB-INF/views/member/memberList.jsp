<%@page import="member.model.MemberListview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="/css/default.css" />">

<meta charset="UTF-8">
<style>
	td>img{
		width :50px;
		height : 50px;
	}
	
	 .table{
		border: solid 0.5px;
	} 
	table>tbody>tr>td{
		border: solid 0.5px;
	}
	
</style><title>회원가입</title>
</head>
<body>

<div>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<table class="table">
			<tr>
				<th>no</th>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>사진</th>
				<th>관리</th>
			</tr>
			
		<c:if test="${not empty listView.memberList }"> <!--MemberListServiceImpl.java에 있다 ListView -->
		<c:forEach items="${listView.memberList}" var="member">
			<tr>
				<td>${member.midx}</td>
				<td>${member.memail}</td>
				<td>${member.mname}</td>
				<td>${member.mpw}</td>
				<td>${member.mphonenum}</td>
				<td><img alt="프사 " src="<c:url value="${member.mphoto}"/>">  </td>
				<td>
				<a href="memberEditForm.do?midx=${member.midx}">수정</a> 
				| 
				<a href="javascript:memberDel(${member.midx})">삭제</a></td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty listView.memberList }">
			<tr>
				<th>조회된 회원이 없습니다.</th>
			</tr>
		</c:if>
	
		</table>

		<div class="paging">
		
		<c:forEach begin="1" end="${listView.pageTotalCount}" var="i">
		
		<a class="paging_num ${i == listView.currentPageNumber ? 'now_page' : '' }">${i}</a>
		
		
		
		</c:forEach>
		
		
		
		</div>




</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>


</body>
</html>