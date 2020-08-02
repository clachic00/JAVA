<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
	<style>
	*{
   background-color: rgb(248, 247, 247);
   margin: auto;
   text-align: center;
   font-family: Nanum Gothic, sans-serif;
   color: rgb(97, 97, 97);
}

#core{
	margin: auto;
}

#boardImg{
	 max-width: 614px; 
		 height: auto;
	
/* 	max-width: 100%; 
	
	height : auto;
 	 */
}


#ImgArea{

height: 500px;
}

	</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div id="writeboard">
		<img src="<%=request.getContextPath()%>/image/icon_profile.png"
			id="writeprofileImg"> <a
			href="<c:url value="/board/boardRegForm.do"/>" id="boardtext">${loginInfo}님,
			무슨 생각을 하고계신가요?</a>
	</div>

	<c:if test="${empty boardList}">
		<core id="first_main_pageCore">
		<div id="first_main_pageFeed">

			<div id="first_main_pageImgArea">
				<div id=first_main_pageFirstCore></div>
				<img src="icon_write.png" width="60px" style="background: white;"
					id="first_main_pageFirstCoreIcon"><br>
				<p width="200px" style="background: white;"
					id="first_main_pageFirstCoreText">
					게시물이 없습니다. <br> 나의 첫 스토리를 올려보세요.
				</p>
				<a href="<c:url value="/board/boardRegForm.do"/>"
					id="first_main_pageFirstCoreButton">게시물 만들기</a>
			</div>

		</div>
		</core>
	</c:if>


	<c:if test="${not empty boardList}">
		<c:forEach items="${boardList}" var="board">

			<core id="core">
			<div id="feed">
				<div id="boardInfo">
					<img src="<%=request.getContextPath()%>/image/icon_profile.png" id="feedprofileImg" style="width:50px"> 
					<input type="hidden" name="bidx" value="${board.bidx}">
					<span style="font-size: 14.5px;">${board.mid}</span><br> 
					<span style="font-size: 12px;">${board.bregdate}</span> 
					<span style="font-size: 12px;" id="site">
					<div id="ImgArea">
					<img src="<c:url value="${board.bphoto}"/>" id="boardImg"></div>
					<div id="boardText">${board.bmessage}</div>
				<img src="<%=request.getContextPath()%>/image/icon_location.png"
						width="30px" style="margin-bottom: -7px;" id="iconBackground">${board.baddr}</span>
					
				</div>
				
				<div id="boardContents">

			<a href="boardDelete.do" id="likeIcon">
		<img src="<%=request.getContextPath()%>/image/like_icon.png" style="width:30px" id="likeIconBackground"></a> 
		<a href="boardDelete.do?idx=${board.bidx}">
		<img src="<%=request.getContextPath()%>/image/icon_delete.png" style="width:30px" class="iconSize"></a> 
		<a href="boardEditForm.do?idx=${board.bidx}">
		<img src="<%=request.getContextPath()%>/image/icon_edit.png" style="width:30px" class="iconSize"></a>
	</div>
				
				
<%-- <div id="boardText">${board.bmessage}</div>
 --%>
            <div id="commentList">

               <c:forEach items="${commentList}" >
                  <c:if test="${comment.bidx == board.bidx}">
                     <span>${comment.mid}</span><br>
                     <span>${comment.cmessage}</span>
                     <a href="../comment/commentDel.do?cidx=${comment.cidx}">삭제</a>
                  </c:if>
               </c:forEach>

				</div>
				 <form action="<%=request.getContextPath()%>/comment/commentReg.do" method="post">
               <div id="comment">
                  <input type="hidden" name="bidx" value="${board.bidx}"> <input
                     type="hidden" name="mid" value="${loginInfo}"> <input
                     type="text" id="commentText" name="cmessage"
                     placeholder="Add a comment..."> <input type="submit"
                     id="postButton" value="post">

               </div>
            </form>
            <br>
            <br>
            <hr>
            <br>
            <br>
         </div>
         </core>

      </c:forEach>

   </c:if>
</body>
</html>