<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function passCheck() {
		//비밀번호가 일치하지 않으면 페이지 이동 안되도록...
		//메세지 띄워주고
		var f = document.registerForm;
		if(f.password.value != f.repassword.value){
			alert("비밀번호가 일치하지 않습니다");
			f.repassword.value="";
			f.repassword.focus();
			return false;
		}
	}
	var xhr;
	function startRequest(){ //비동기 요청 내용을 처리하는 함수

		var id = document.registerForm.id.value;
		var resultView = document.getElementById("idCheckResult");
		if(id.length<4){
			resultView.innerHTML = "<font color='red'>아이디는 4자 이상!!</font>";
			return;
			
		}
		//위 if가 true가 아니면은 비동기 통신으로 로직을 전개 시킨다.
		xhr = new XMLHttpRequest();
		//alert(xhr.readyState); //0
		
		xhr.onreadystatechange = callback;
		//alert(xhr.readyState); // 0
		
		xhr.open("post", "idCheck.do");
		//alert(xhr.readyState); //1
		
		xhr.setRequestHeader("Content-Type", 
				"application/x-www-form-urlencoded;charset=utf-8");
		
		xhr.send("id="+id);
		//alert(xhr.readyState); //1
	}
	
	function callback() { //비동기 응답받은 내용을 처리하는 함수
		if(xhr.readyState==4){ //xhr객체가 안전하게 브라우저로 다시 잘 안착했다면...완벽하게 도착했다면
			if(xhr.status==200){ //서버로 가서 작업한 일이 성공적으로 수행되었다면
				var flag = xhr.responseText;
				var resultView = document.getElementById("idCheckResult");
				
				if(flag=='true') resultView.innerHTML = 
					"<font color='red'><b>해당 ID 사용 불가</b></font>";
				else resultView.innerHTML = 
					"<font color='blue'><b>해당 ID 사용 가능</b></font>";
			}
		}
	}
</script>
</head>
<body>
<h2 align="center"><b>Register Member Form....</b></h2><p>
<form action="register.do" method="post" name="registerForm" onsubmit="return passCheck()">
ID : <input type="text" name="id" required="required" onkeyup="startRequest()">
<!-- <input type="button" value="중복확인" onclick="startRequest()"> -->
<span id="idCheckResult"></span>
<br><br>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input type="submit" value="member register">
</form>
</body>
</html>












