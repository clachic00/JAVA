<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
	<h1 id="header">Pado Project</h1>
	<ul id="nav">
		
		<li><a href="${pageContext.request.contextPath}/member/memberRegForm.do">회원가입</a></li>
		
		<li><a href="<c:url value="/member/memberList.do"/>">회원 리스트</a></li>
		
		<c:if test="${!empty sessionId}">
		<li><a href="<c:url value="member/logout.do"/>">로그아웃</a></li>
		</c:if>
		
		<c:if test="${empty sessionId}">
		<li><a href="<c:url value="/member/loginRegForm.do"/>">로그인</a></li>
		</c:if>
				<li><a href="<c:url value="/comment/commentForm.do"/>">댓글</a></li>
		
		<li><a href="<c:url value="/member/mypage.do"/>">마이페이지</a></li>
		<li><a href="<c:url value="/guestbook/list.jsp"/>">방명록(비회원)</a></li>
		<li><a href="<c:url value="/board/list.jsp"/>">방명록(회원제)</a></li>
	</ul>