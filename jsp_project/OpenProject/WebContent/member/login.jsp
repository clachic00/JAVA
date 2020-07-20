<%@page import="member.model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("remember"); 

	String redirectUri = request.getParameter("redirectUri");

	
	//로그인 처리
	
	boolean loginChk = false;
	if(uid.equals(pw)){
		LoginInfo loginInfo = new LoginInfo(uid,pw,"test@gmail.com","default.jpg");
	
		session.setAttribute("loginInfo",loginInfo);
		
		loginChk = true;
	
	}


	System.out.println(loginChk);
	

	if(loginChk){
		
		String cookieName = "uid";
		String cookiepath = request.getContextPath();
		
		if(chk!=null){
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 60*60*24*365));
			
		}else{
				response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 0));
				
		}
				response.sendRedirect(redirectUri);
		
				
		
	}	else{
		%>
		
		
		<script>
		alert('아이디 또는 비밀번호를 확인 후 다시 시도해 주세요');
		history.go(-1);

		</script>
		
<% 		
		
		
	}

	%>



<%-- 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
<style>
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div>
		<h1>로그인</h1>
		
		<hr>
		<table>
			<tr>
				<td>ID</td>
				<td> <%= uid %></td>
			</tr>
			<tr>
				<td>PW</td>
				<td> <%= pw %> </td>
			</tr>
			<tr>
				<td></td>
				<td> 
					<%
						if(chk!=null){
							out.println("아이디를 저장합니다.");
						} else {
							out.println("아이디를 저장하지 않습니다.");
						}
					%>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><%= rediectUri %></td>
			</tr>
		</table>
	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
 --%>