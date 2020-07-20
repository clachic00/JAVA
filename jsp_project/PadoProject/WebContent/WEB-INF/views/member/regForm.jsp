<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<form id="regForm" action="memberReg.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(email)</td>
					<td> <input type="email" name="memail" id="memail" >
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
					<td>사진</td>
					<td> <input type="file" name="mphoto"> </td>
				</tr>
				<tr>
					<td>연락처</td>
					<td> <input type="text" name="mphonenum"> </td>
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
	</div>











</body>

<script>
   $(document).ready(function(){
      
      $('#regForm').submit(function(){
         
         if(!$('#idchk').prop('checked')){
            alert('아이디 중복체크는 필수 항목입니다.');
            $('#uid').focus();
            return false;
         }
         
         
         
      })
      
      $('#uid').focusin(function(){
         
         $(this).val('');
         $('#idchk').prop('checked', false);
         
         $('#checkMsg').text('');
         
         $('#checkMsg').removeClass('chk_not');
         $('#checkMsg').removeClass('chk_ok');
         
         
      });
      
      $('#uid').focusout(function(){
         
         if($(this).val().length<1){
            $('#checkMsg').text("아이디 항목은 필수 항목입니다.");
            
            $('#checkMsg').addClass('chk_not');
            
            return false;
         }
         
         // 비동기 통신
         $.ajax({
            url : 'idCheck.do',
            data : {uid : $(this).val()},
            success : function(data){
               if(data == 'Y'){
                  $('#checkMsg').text("사용가능한 아이디 입니다.");
                  
                  $('#checkMsg').addClass('chk_ok');
                  
                  $('#idchk').prop('checked', true);
               }else {
                  $('#checkMsg').text("사용불가능한 아이디 입니다.");
                  
                  $('#checkMsg').addClass('chk_not');
                  
                  $('#idchk').prop('checked', false);
               }
            }
         });
      });
   });
</script>





</html>