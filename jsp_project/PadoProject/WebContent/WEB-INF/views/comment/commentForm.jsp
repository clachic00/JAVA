<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style></style>
<title>Insert title here</title>
</head>
<body>

<form action="commentWrite.do" method="post" >



<table>


<tr>
	<td>index</td>
	<td> <input type="text" name="cidx" value=1 readonly> </td>
</tr>
<tr>
	<td>게시판 번호</td>
	<td> <input type="text" name="bidx"  value=1 readonly> </td>
</tr>
<tr>
	<td>아이디</td>
	<td> <input type="text" name="memail"  value=1 readonly> </td>
</tr>
<tr>
	<td>댓글</td>
	<td> <textarea name="comment"/></textarea></td>
</tr>
<tr>
<td><input type="submit" value="게시"></td>

</tr>




</table>
</form>

</body>
</html>

<%-- value="${board.bidx}"
value="${comment.cidx}"
value="${member.memail}" --%>




