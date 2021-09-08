<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	var amount = 1;
	var totalPrice = 0;
	//var update = localStorage.getItem(key);
	
	$(function() {	
		
		refreshPage();
		
		$('[name=up]').on('click', function(){
			//alert("up");
			$(this).next().html(eval($(this).next().html())+1);
			amount = $(this).next().html();
			totalPrice += eval($(this).parent().prev().html());
			$('tfoot tr td span').html('<font size=30 style=font-family:georgia;>'+totalPrice+'</font>');
			//localStorage.setItem();
		});
		
		$('[name=down]').on('click', function(){
			//alert("down");
			if(amount>1){
				$(this).prev().html(eval($(this).prev().html())-1);
				amount = $(this).prev().html();
				totalPrice -= eval($(this).parent().prev().html());
				$('tfoot tr td span').html('<font size=30 style=font-family:georgia;>'+totalPrice+'</font>');
			}
			
		});
	}); 

	function refreshPage(){
		var html = "";
		totalPrice = 0;
		var count = 0;
		amount = 1;
		
		//for문 사용해서 localStorage에 저장된 내용을 받아와서 tbody안에 table 안에 적절한 위치에 출력
		for(var key in localStorage){
			if(key=='length') break; //이 부분 중요!! (내가 저장한 값들 바로 뒤에 default로 'length'라는 key가 저장되어있다)
			var data = localStorage.getItem(key).split(","); //url,name,price
			html += '<tr><td>'+ ++count +'</td><td><img src='+data[0]
			+' width=80 height=80></td><td>'+data[1]+'</td><td>'
			+data[2]+'</td><td><img src=img/up.jpg width=15 height=15 name=up style=cursor:pointer;><div>'+amount+
			'</div><img src=img/down.jpg width=15 height=15 name=down style=cursor:pointer;></td>'
			+'<td><input type=checkbox name=deleteCart value='+key+'></td></tr>';
		
			totalPrice += parseInt(data[2]);
			
		}
		
		$('tbody').append(html);
		$('tfoot tr td span').html('<font size=30 style=font-family:georgia;>'+totalPrice+'</font>');
	}
	
	function deleteItem(){
		var check = document.getElementsByName("deleteCart");
		
		for(var i=0; i<check.length; i++){
			if(check[i].checked == true){
				localStorage.removeItem(check[i].value);
				location.reload();
			}
		}
		
	}
</script>
</head>
<body>
<h1 align="center">장바구니</h1>
<table align="center" width="600" border="2">
	<thead bgcolor="orange">
		<tr>
			<th>번호</th><th>상품이미지</th><th>상품명</th><th>상품가격</th><th>수량</th>
			<th><button onclick="deleteItem()">삭제</button></th>
		</tr>
	</thead>
	<tbody align="center">
	</tbody>
	<tfoot bgcolor="orange">
		<tr>
			<td colspan="6" align="right"><font color="gray" size="5">총 결제금액 : </font><span id="priceSum"></span></td>
		</tr>
	</tfoot>
</table>
<div align="center">
	<a href="itemList.do">쇼핑 계속하기</a>
</div>
</body>
</html>