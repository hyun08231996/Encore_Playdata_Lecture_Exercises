<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="http://cdn.jsdelivr.net/gh/joungkyun/font-d2coding/d2coding.css" rel="stylesheet" type="text/css">
<style type="text/css">
	body{
		width: 350px;
		margin: 0 auto;
		font-family: D2Coding, 'D2 coding', monospace;
	}
	table{
		width: 100%;
		align: center;
	}
	th, .bg{
		background-color: lightgray;
	}
	input[type=text]{
		width: 80%;
	}
	#info:hover{
		cursor: pointer;
		background-color: yellow;
	}
	#info:focus{
		background-color: yellow;
	}
</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<c:url value="phone" var="phone" />
<script type="text/javascript">
$(function(){
	getPhones();
	
	$('#phone-list').on('click', '.phoneInfo', function(){
		let num = $(this).children().eq(0).text();
		phoneInfo(num);
	});
	
	$('#phoneInsert').on('click', function(){
		phoneInsert();
	});
	
	$('#phoneUpdate').click(function(){
		phoneUpdate();
	});
	
	$('#phoneDelete').click(function(){
		phoneDelete();
	});
});

function getPhones(){
	$.ajax({
		url:'${phone}',
		type:'get',
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr, status, message){
			alert("error : "+message);
		},
		
		success:function(data){
			var temp = "";
			$('#phone-list').empty();
			if(data!=null){
				$.each(data, function(idx, phone) {
					temp+= "<tr class='phoneInfo' id='info' tabindex='0'>";
					temp+= "<td>"+phone.num+"</td>";
					temp+= "<td>"+phone.model+"</td>";
					temp+= "<td>"+phone.price+"</td>";
					temp+= "<td>"+phone.company.vendor+"</td>";
					temp+= "</tr>";
				});
				$('#phone-list').append(temp);
				$("#status").append("<font color=green>조회 성공</font>");
			}else{
				$("#status").append("<font color=red>조회 실패: " + data+"</font>");
			}
			
		}
		
	});
}

function phoneInfo(num){
	//alert(num);
	$.ajax({
		url:"${phone}/"+num,
		type:'get',
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr,status,message){
			alert("error : "+message);
			
		},

		success:function(data,textStatus,jqXHR) {
			$('#status').empty();
		    if (jqXHR.status == "204") {
		    	$('#status').append("<font color=red>조회실패: "+message+"</font>");
		    }
		    else{
		    	$('#status').append("<font color=green>조회성공 : "+data.model+"</font>");
				$('input[name=num]').val(data.num);
				$('input[name=model]').val(data.model);
				$('input[name=price]').val(data.price);
				$('select[name=vcode]').val(data.vcode);    	
		    }
		}

	});
	
}

function phoneInsert(){
	$.ajax({
		url:"${phone}",
		type:"post",
		data:JSON.stringify({
			"num":$('input[name=num]').val(),
			"model":$('input[name=model]').val(),
			"price":$('input[name=price]').val(),
			"vcode":$('select[name=vcode]').val()
		}),
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr){
			console.log("error "+xhr.status);
		},
		
		success:function(data,textStatus,jqXHR) {
		    if (jqXHR.status == "204") {
		    	alert("등록할 핸드폰 정보를 입력하세요.");
		    }
		    else{
				alert("INSERT 성공");	
				location.reload();
		    }
		    
		}
	});
}

function phoneUpdate(){
	$.ajax({
		url:"${phone}",
		type:"put",
		data:JSON.stringify({
			"num":$('input[name=num]').val(),
			"model":$('input[name=model]').val(),
			"price":$('input[name=price]').val(),
			"vcode":$('select[name=vcode]').val()
		}),
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr){
			alert("error "+xhr.status);
		},
		
		success:function(data,textStatus,jqXHR) {
		    if (jqXHR.status == "204") {
		    	alert("업데이트 모델이 없습니다");
		    }
		    else{
				alert("UPDATE 성공");
				location.reload();
		    }
		    
		}
	});
}

function phoneDelete(){
	var num = $('input[name=num]').val();
	if(num==""){
		alert("삭제 모델을 선택하세요.")
	}
	$.ajax({
		url:"${phone}/"+num,
		type:"delete",
		contentType:"application/json;charset=utf-8",
		
		error:function(xhr){
			console.log("error "+xhr.status);
		},
		
		success:function(data,textStatus,jqXHR) {
		   alert("DELETE 성공");
		   location.reload();
		}
	});
}
</script>
</head>
<body>

<h1>휴대전화 목록</h1>
<div>
	<table border="1">
		<tr>
			<th>모델번호</th><th>모델이름</th><th>가격</th><th>제조사명</th>
		</tr>
		<tbody id="phone-list">
		</tbody>
	</table>
</div>
<div id='status'></div>
<br>
<h1>휴대전화 정보</h1>
<div id="phone-info">
	<table>
		<tr>
			<td class='bg' width="120px">모델번호</td><td><input type="text" name="num" id="num" required="required"></td>
		</tr>
		<tr>
			<td class='bg'>모델명</td><td><input type="text" name="model" id="model" required="required"></td>
		</tr>
		<tr>
			<td class='bg'>가격</td><td><input type="text" name="price" id="price" required="required"> 원</td>
		</tr>
		<tr>
			<td class='bg'>제조사</td>
			<td>
				<select name="vcode" id="vcode" required="required">
				<option value='' selected>--선택--</option>
				<option value="10">삼성</option>
				<option value="20">엘지</option>
				<option value="30">애플</option>
				</select>
			</td>
		</tr>
	</table>
	<br>
	<input type='button' value='추가하기' id='phoneInsert'>
	<input type='button' value='수정하기' id='phoneUpdate'>
	<input type='button' value='삭제하기' id='phoneDelete'>
</div>
</body>
</html>