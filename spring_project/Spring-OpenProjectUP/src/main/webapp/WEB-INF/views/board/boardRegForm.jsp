<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td>제목을 입력하세요</td>
					<td> <input type="text" name="btitle" id="uid" ></td>
				</tr>
				<tr>
					<td>내용을 입력해주세요</td>
					<td> <textarea name="bmsg" required/> </td>
				</tr>
				<tr>
					<td>플랜을 선택해주세요</td>
					<td> <select>
					
					<option>1</option>
					<option>2</option>
					<option>3</option>
					
					
					</select>
					 </td>
				</tr>
			
					<td>사진</td>
					<td> <input type="file" name="photo"> </td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" name="작성완료">
						<input type="reset">
					</td>
				</tr>




</table>










</form>

</body>
</html>