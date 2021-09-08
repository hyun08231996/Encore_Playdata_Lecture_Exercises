<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" /> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function Register(){
		if (document.registerFrm.id.value == "") {
			alert("아이디를 입력하세요");
			document.registerFrm.id.focus();
		} else if (document.registerFrm.pw.value == "") {
			alert("비밀번호를 입력하세요");
			document.registerFrm.pw.focus();
		} else if (document.registerFrm.pw2.value == "") {
			alert("비밀번호 확인을 입력하세요");
			document.registerFrm.pw2.focus();
		} else if (document.registerFrm.name.value == "") {
			alert("이름을 입력하세요");
			document.registerFrm.pw.focus();
		} else if (document.registerFrm.email.value == "") {
			alert("이메일을 입력하세요");
			document.registerFrm.pw.focus();
		} else {
			alert("회원가입 성공!");
			document.registerFrm.submit();
		}
	}
	
	$(function(){
		$('#checkId').on('click', function(){
			//alert("ajax");
			var id = $('#id').val();
			//alert(id);
    		$.ajax({
    			type:"post",
    			url:"checkId.do",
    			data:{"id":id}, //json 방식
    			
    			//서버측에서 보내는 데이터를 받아서 응답하는 callback 함수를 호출
    			success:function(result){//서버쪽에서 보낸 데이터를 받는 인자값을 지정해줘야한다... result
    				//alert(result);
    				var result = JSON.parse(result).result; //can use result["bvo"].title instead
    				//alert(result);
    				if(result == "true"){
    					//alert("true");
    					$('#checkIdMsg').html('<font color=red><b> 이미 사용중인 아이디 입니다.</b></font>');
    					$('#id').val('');
    					$('#id').focus();
    				}else{
    					//alert("false");
    					$('#checkIdMsg').html('<font color=green><b> 사용 가능한 아이디 입니다.</b></font>');
    					$('#pw').focus();
    				}
    				
    			},
    			
    			//에러가 발생되면 호출되는 callback 함수 연결..
    			error:function(xhr, status, message){
    				//alert("응답시간이 지연...Error 처리!!"+message+" status : "+status);
    				alert("error :: "+message);
    			},
    			timeout:5000 //1초 동안 서버로 부터의 응답이 없으면 에러 발생(응답 대기시간을 지정)
    		});//ajax
		});//on
		
		$('#pw2').blur(function(){
			var pass = $('#pw').val();
			var repass = $('#pw2').val();
			if(pass == repass){
				$('#checkPass').html('<font color=green><b> 비밀번호가 일치합니다.</b></font>');
				$('#name').focus();
			}else{
				$('#checkPass').html('<font color=red><b> 비밀번호가 일치하지 않습니다.</b></font>');
				$('#pw2').focus();
			}
		});
	});//ready
</script>
<style type="text/css">
	table {
	  border-collapse:separate; 
	  border-spacing: 0 1em;
	}
</style>
</head>
<body>
<form method="post"
		action="memberRegister.do"
		name="registerFrm">
		<table>
			<tr>
				<td><font color="red">*</font>아이디</td>
				<td>
					<input type="text" name="id" id="id" required="required">
					<button id="checkId">중복확인</button>
					<span id="checkIdMsg"></span>
				</td>
			</tr>
			<tr>
				<td><font color="red">*</font>비밀번호</td>
				<td>
					<input type="password" name="pw" id="pw" required="required">
				</td>
			</tr>
			<tr>
				<td><font color="red">*</font>비밀번호 확인</td>
				<td>
					<input type="password" name="pw2" id="pw2" required="required">
					<span id="checkPass"></span>
				</td>
			</tr>
			<tr>
				<td><font color="red">*</font>이름</td>
				<td>
					<input type="text" name="name" id="name" required="required">
				</td>
			</tr>
			<tr>
				<td>별명</td>
				<td>
					<input type="text" name="nickName" id="nickName">
				</td>
			</tr>
			<tr>
				<td><font color="red">*</font>이메일</td>
				<td>
					<input type="text" name="email" id="email" required="required">
				</td>
			</tr>
			<tr>
				<td>홈페이지</td>
				<td>
					<input type="text" name="homePage" id="homePage">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" id="address">
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type="text" name="hobby" id="hobby">
				</td>
			</tr>
		</table>
		<font color="red">* required</font>
		<br>
		<button onclick="Javascript:Register();">가입하기</button>
	</form>
	
	
</body>
</html>