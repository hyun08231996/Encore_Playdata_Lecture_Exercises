<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var xhr;
	function startRequest(){ //비동기 요청 내용을 처리하는 함수
		xhr = new XMLHttpRequest();
		//alert(xhr.readyState); //0
		
		var id = document.getElementById("memberId").value;
		
		xhr.onreadystatechange = callback;
		//alert(xhr.readyState); // 0
		
		xhr.open("post", "find.do");
		//alert(xhr.readyState); //1
		
		xhr.setRequestHeader("Content-Type", 
				"application/x-www-form-urlencoded;charset=utf-8");
		
		xhr.send("id="+id);
		//alert(xhr.readyState); //1
	}
	
	function callback() { //비동기 응답받은 내용을 처리하는 함수
		if(xhr.readyState==4){ //xhr객체가 안전하게 브라우저로 다시 잘 안착했다면...완벽하게 도착했다면
			if(xhr.status==200){ //서버로 가서 작업한 일이 성공적으로 수행되었다면
				document.getElementById("resultView").innerHTML = 
					"<font color='green' size=3>"+decodeURI(decodeURIComponent(xhr.responseText))+"</font>";
			}
		}
	}
</script>
</head>
<body>
<h2 align="center">ID LIST INFORMATION...</h2>
<h3>list에서 특정 아이디를 선택해주세요...</h3>
<p></p>
<select id="memberId" onchange="startRequest()">
	<option value="">==ID CHOIDE==</option>
	<c:forEach items="${idList}" var="id">
		<option value="${id}">${id}</option>
	</c:forEach>
</select>

<span id="resultView"></span>
</body>
</html>