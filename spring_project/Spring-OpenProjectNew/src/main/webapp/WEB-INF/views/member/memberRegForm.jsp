<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="regForm" method="post" enctype="multipart/form-data">

<table>
				<tr>
					<td>아이디(email)</td>
					<td> <input type="email" name="uid" id="uid" >
						 <span  id="checkmsg"></span>
						 <input type="checkbox" name="idchk" id="idchk">
					 </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="upw" required> </td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="uname" required> </td>
				</tr>
				<tr>
					<td>연락처</td>
					<td> <input type="text" name="uphone" required> </td>
				</tr>
				<tr>
					<td>사진</td>
					<td> <input type="file" name="photo"> </td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" name="회원가입">
						<input type="reset">
					</td>
				</tr>





</table>

</form>




</body>
</html>