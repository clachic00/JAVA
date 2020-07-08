<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

table td{
	padding:10px;
}

intput, textarea{
	padding : 5px;
}


</style>
<title>Insert title here</title>
</head>
<body>

<h3>방명록 글쓰기</h3>
	<hr>
	
	<form action="messageWrite.jsp" method="post">
	<table>
		<tr>
			<td><label for ="">이름</label></td>
			<td><input type="text" name="uname" id = "uname" required></td>
		</tr>
		<tr>
			<td><label for="pw">비밀번호</label></td>
			
			<td><input type="password" name="pw" id="pw" required></td>
		</tr>
			<tr>
				<td><label for="message">메세지</label></td>
				<td><textarea name="message" id="message" rows="10" cols="20" required></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="글쓰기">
					<input type="reset">				
				</td>
			</tr>
		</table>


</form>

</body>
</html>