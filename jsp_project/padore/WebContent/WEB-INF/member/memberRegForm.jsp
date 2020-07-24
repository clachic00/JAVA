






이거 지금 모달 띄우는거 하고있어서 주석처리한게 우리 코드고 밑에 있는건 지금 시험삼아하고있는거야!!!!







<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>
	.check_ok {
		color : blue;
	}
	.check_not {
		color : red;
	}
	#idchk {
		display: none;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>

	<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<form id="regForm" action="memberReg.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(email)</td>
					<td> <input type="email" name="mid" id="mid" >
						 <span  id="checkmsg"></span>
						 <input type="checkbox" name="idchk" id="idchk">
					 </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="mpw" required> </td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="mname" required> </td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td> <input type="text" name="mphonenumber" required> </td>
				</tr>
				<tr>
					<td>사진</td>
					<td> <input type="file" name="mphoto"> </td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" name="회원가입" >
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
	</div>

	<%@ include file="/WEB-INF/include/footer.jsp" %>
</body>
</html>
<script>
	
	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			
			if(!$('#idchk').prop('checked')){
				alert('아이디 중복 체크는 필수 항목 입니다');
				$('#mid').focus();
				return false;
			}
			
			
			
		});
		
		$('#mid').focusin(function(){
			
			$(this).val('');
			$('#idchk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});
		
		$('#mid').focusout(function(){
			
			if($(this).val().length<1){
				$('#checkmsg').text("아이디 항목은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}
			
			// 비동기 통신
			$.ajax({
				url : 'idCheck.do',
				data : { mid : $(this).val()},
				success : function(data){
					if(data == 'Y'){
						$('#checkmsg').text("사용가능한 아이디 입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked', true);
					} else {
						$('#checkmsg').text("사용이 불가능한 아이디 입니다.");
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked', false);
					}
				}
			});
			
			
		});
		
		
	});
	
	
</script> --%>


<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>

<link rel="stylesheet" href="default.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 50%; /* Could be more or less, depending on screen size */                          
}
/* The Close Button */
.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}
.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}

</style>
</head>
<body id="loginmain">
<div class= "loginformcontainer">


<div>
    <h1 class="subtitle">회원 가입</h1>
    <hr>
        <table>
            <tr>
                <td>아이디(email)</td>
                <td> <input type="email" name="mid" id="mid" >
                     <span  id="checkmsg"></span>
                     <input type="checkbox" name="idchk" id="idchk">
                 </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td> <input type="password" name="mpw" required> </td>
            </tr>
            <tr>
                <td>이름</td>
                <td> <input type="text" name="mname" required> </td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td> <input type="text" name="mphonenumber" required> </td>
            </tr>
            <tr>
                <td>사진</td>
                <td> <input type="file" name="mphoto"> </td>
            </tr>
            <tr>
                <td></td>
                <td> 
                    <button id="myBtn">작성완료</button>
                    <input type="reset">
                </td>
            </tr>
        </table>
    </div>
    
    
    <script>
    <%
%>

   

</script>
        <form id="regForm" action="memberReg.do" method="post" enctype="multipart/form-data">

        <div id="myModal" class="modal">
 
            <!-- Modal content -->
            <div class="modal-content">
              <span class="close">&times;</span>   
            
              <table>
                <tr>
                    <td>아이디(email)</td>
                    <td>  </td>
                </tr>
               
                <tr>
                    <td>비밀번호</td>
                    <td> </td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td> <input type="text" name="mname" required> </td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td> <input type="text" name="mphonenumber" required> </td>
                </tr>
                <tr>
                    <td>사진</td>
                    <td> <input type="file" name="mphoto"> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> 
						<input type="submit" name="회원가입" >
                        <input type="reset">
                    </td>
                </tr>
            </table>                                                         
            </div>
    </form>
</div>

</body>
</html>
<script>

 var value = $('#mid').val(); 

// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];                                          

// When the user clicks on the button, open the modal 
btn.onclick = function() {
 modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
 modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
 if (event.target == modal) {
     modal.style.display = "none";
 }
}

function showRequest(){ 
	
	var flag = true; //무조건 일단 true
	
	if(!$("#mid").val()) { //jQuery에서 가져오는 값이 없으면,
	
		alert("제목을 입력하세요!");
		$("#mid").focus();
		return false;
	
	}
	
	if(!$("#mpw").val()) { 
		
		alert("내용을 입력하세요!");
		$("#mpw").focus();
		return false;
	
	}
	
	// subject, content 둘 다 값이 넣어져 있으면
	return flag;
	
}
</script>