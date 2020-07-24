<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	#board {
		border: 1px solid black;
		width: 400px;
		height: 700px;
	}
</style>
</head>
<body>
<div id="board">
	<table border="1">
	<c:if test="${empty boardList}">
		<tr>
			<td>게</td>
			<td>시</td>
			<td>물</td>
			<td>없</td>
			<td>어</td>
			<td>요</td>
		</tr>
	</c:if>
	<c:if test="${not empty boardList}">
		<c:forEach items="${boardList}" var="board">	
			<tr>
				<td>${board.bidx}</td>
				<td>${board.bid}</td>
				<td>${board.bphoto}</td>
				<td>${board.bmessage}</td>
				<td>${board.regdate}</td>
				<td><a href="boardEditForm.do?idx=${board.bidx}">수정</a>/<a href="boardDelete.do?idx=${board.bidx}">삭제</a></td>
			</tr>
			</div>
			<div>
			<form action="commentReg.do" method="post">
				<tr>
					<td><input type="hidden" name="cid" value="${board.bid}"></td>
					<td><textarea rows="5" cols="50" name="commnet" id="comment"></textarea></td>
					<td><input type="submit" value="작성"></td>
				</tr>
		</form>
		</c:forEach>

	</c:if>
		</table>
</div>
</body>
</html> --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
</head>
<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div id="writeboard">
	<img src="Koala.jpg" id="writeprofileImg">

	<textarea id="boardtext" rows="3" cols="70">  ${member.mid}님, 무슨 생각을 하고계신가요?</textarea>
</div>
<c:if test="${not empty boardList}">
	<c:forEach items="${boardList}" var="board">

		<core id="core">
		<div id="feed">
			<div id="boardInfo">
				<img src="Koala.jpg" id="feedprofileImg"> <span
					style="font-size: 14.5px;">${board.bid}</span><br> <span
					style="font-size: 12px;">${board.regdate}</span> <span
					style="font-size: 12px;" id="site"><img
					src="<%=request.getContextPath()%>/image/icon_location.png" width="30px"
					style="margin-bottom: -7px;" id="iconBackground">서울시 종로구</span>

			</div>
			<div id="ImgArea">
				<img src="<c:url value="${board.bphoto}"/>" id="boardImg">

			</div>
			<div id="boardContents">

				<a href="boardDelete.do" id="likeIcon"><img src="<%=request.getContextPath()%>/image/like_icon.png"
					width="30px" id="likeIconBackground"></a> <a
					href="boardDelete.do?idx=${board.bidx}"><img src="<%=request.getContextPath()%>/image/icon_delete.png"
					class="iconSize"></a> <a href="boardEditForm.do?idx=${board.bidx}"><img
					src="<%=request.getContextPath()%>/image/icon_edit.png" class="iconSize"></a>


			</div>
			<div id="boardText">${board.bmessage}</div>

			<div id="commentList">
	
				<div>1</div>
				<div>2</div>
				<div>3</div>
				<div>더보기</div>
			</div>
			<form action="<c:url value="commentReg.do"/>" method="post">
			<div id="comment">
				<input type="hidden" name="bidx" value="${board.bidx}">
				<input type="hidden" name="mid" value="세션들어가야함">
				<input type="text" id="commentText" value="Add a comment..." name="cmessage"> 
				<input type="submit" id="postButton" value="post">
			
			</div>
			</form>
		</div>
		</core>

	</c:forEach>

</c:if>
</body>
</html>