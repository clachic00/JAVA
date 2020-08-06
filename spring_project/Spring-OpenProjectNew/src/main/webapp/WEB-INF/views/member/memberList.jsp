<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">회원 리스트</h1>

		<c:if test="${not empty listView  }">

		<div>전체회원 ${listView.memberTotalCount} 명</div>
		<hr>
		
		<div class="searchBox">
		<form>
			<select name="searchType">
				<option value="id">ID</option>
				<option value="name">NAME</option>
				<option value="both">ID + NAME</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>		
		</div>

		<table class="table">
			<tr>
				<th>no</th>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>사진</th>
				<th>연락처</th>
				<th>관리</th>
			</tr>
			
		<c:if test="${not empty listView.memberList }">
		<c:url value="${initParam['memberUploadPath']}" var="imagePath"/>
		<c:forEach items="${listView.memberList}" var="member">
			<tr>
				<td>${member.uidx}</td>
				<td>${member.uid}</td>
				<td>${member.uname}</td>
				<td>${member.upw}</td>
				<td><img alt="프사 " src="${imagePath}/${member.uphoto}">  </td>
				<td>${member.uphone}</td>
				<td> <a href="view/${member.uidx}">정보보기</a>
				
				<%-- <a href="memberEdit?uidx=${member.uidx}">수정</a> 
				<a href="javascript:memberDel(${member.uidx})">삭제</a> --%></td>
			</tr>
		</c:forEach>
		</c:if>
		
		<c:if test="${empty listView.memberList }">```
			<tr>
				<th colspan="7">조회된 회원이 없습니다.</th>
			</tr>
		</c:if>


		</table>
		
		<div class="paging">
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="i">
			
			<a class="paging_num ${i == listView.currentPageNumber ? 'now_page' : ''}" 
			href="memberList?page=${i}&searchType=${param.searchType}&keyword=${param.keyword}" >${i}</a>
			
			</c:forEach>
		</div>



		</c:if>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>