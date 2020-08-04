<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page trimDirectiveWhitespaces="true" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div>
		<h1 class="subtitle">로그인</h1>
		<hr>
		<form method="post">
		
					<input type="text" name="redirecUri" value="${header.referer}" style=" width : 50% ;" >			
		
		
		<table class="table">
				<tr>
					<td> ID </td>
					<td> <input type="text" name="uid" value="${cookie.uid.value}"> </td>
				</tr>
				<tr>
					<td> PW </td>
					<td> <input type="password" name="upw"> </td>
				</tr>				
				<tr>
					<td></td>
					<td> <input type="checkbox" name="remember" value="r" ${cookie.uid != null ? 'checked' : '' } > 아이디 기억하기  </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="로그인"> </td>
				</tr>
			</table>
			
		</form>

	</div>



	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>