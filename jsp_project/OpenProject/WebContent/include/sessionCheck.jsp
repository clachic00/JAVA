<%@page import="member.model.LoginInfo"%>
<%@page pageEncoding="utf-8" %>
<%
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
	if(loginInfo==null){
		%>
	<script>
		alert('로그인이 필요한 페이지 입니다.');		
		location.href='<%= request.getContextPath()%>/member/loginForm.jsp';
	</script>
		<%
	}
%>