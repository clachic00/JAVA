<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
	<h1 id="header">PlanIt Project</h1>
	<ul id="nav">
		
		<li><a href="${pageContext.request.contextPath}/member/memberReg">회원가입</a></li>
		
		<li><a href="<c:url value="/member/memberList"/>">회원 리스트</a></li>
		<li><a href="<c:url value="/member/memberListToJson.do"/>">member-JSON</a></li>
		<li><a href="<c:url value="/member/memberList.xml"/>">member-XML</a></li>
		
		<c:if test="${!empty loginInfo}">
		<li><a href="<c:url value="/login/logout"/>">로그아웃</a></li>
		</c:if>
		
		<c:if test="${empty loginInfo}">
		<li><a href="<c:url value="/login/login"/>">로그인</a></li>
		</c:if>
		
		<li><a href="<c:url value="/member/mypage/mypage"/>">마이페이지</a></li>
		<li><a href="<c:url value="/board/boardList"/>">게시글 목록</a></li>
		<li><a href="<c:url value="/board/boardregForm"/>">글쓰기</a></li>
	</ul>
	
	
	
	
	
	
	