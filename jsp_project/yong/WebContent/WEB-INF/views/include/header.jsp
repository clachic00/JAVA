
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/*  Boolean loginCheck = session.getAttribute("memberId")==null?true:false; */

/* String id = (String) session.getAttribute("memberId");

Boolean loginCheck = false;

if (id == null) {
	loginCheck = true;
} */
%>
<header>
	<div id="logoSide">
		<img src="<%=request.getContextPath()%>/image/main_logo.png" id="logo">

		<nav>
			<ul>
				<li><a href="<c:url value="/member/logout.do"/>" class="navIcon" style="color: lightsteelblue;">logout</a></li>
				<li><a href="<c:url value="/member/mypage.do"/>"><img src="<%=request.getContextPath()%>/image/icon_mypage.png" width="30px" style="background: white;" class="navIcon"></a></li>
             
             	<li><a href="<c:url value="/board/boardRegForm.do"/>"><img src="<%=request.getContextPath()%>/image/icon_write.png" width="30px" style="background: white;" class="navIcon"></a></li>
             
             	<li><a href="<c:url value="/board/boardList.do"/>"><img src="<%=request.getContextPath()%>/image/icon_home.png" width="30px" style="background: white;" class="navIcon"></a></li>
             
           </ul>
         </nav>
      
      
      </div>
    </header>