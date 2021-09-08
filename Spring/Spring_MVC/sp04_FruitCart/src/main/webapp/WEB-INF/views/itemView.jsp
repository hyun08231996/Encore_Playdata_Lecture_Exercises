<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#first{background-color: orange;}
	*{ color:  navy;}
	/*body{
		margin-left:25%;
		margin-right:25%;
		
	}
	#count{
		background-color:lightgray;
		padding:5px;
	}
	#count b{
		text-align:center;
	}

	#image{
		width:50%;
		height:500px;
		float:left;
	}
	#details{
		margin-left:10px;
		width:45%;
		height:500px;
		float:left;
		display:in-line;
		overflow:hidden;
		
	}
	
	#return{
		clear:both;
		
	}*/
	
</style>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script>
	$(function() {
		$('[name=addCart]').click(function(){
			localStorage.setItem($(this).attr('id'), $(this).val());
			var conf = confirm("장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?");
			if(conf == true){
				location.href="cartView.jsp";
			}
		});
		
		$('[name=goToCart]').click(function(){
			location.href="cartView.jsp";
		});
		
	});
</script>
</head>
<body>
<h1 align="center">${item.name}</h1>
<table align="center" width="600" id="first">
	<tr>
		<td align="right">
			조회수 : ${item.count} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button name="addCart" id="${item.itemNumber}" value="${item.url},${item.name},${item.price}">장바구니 담기</button>
			&nbsp;&nbsp;<button name="goToCart">장바구니 확인</button>
		</td>
	</tr>
</table>

<table align="center" width="600">
	<tr>
		<td rowspan="3">
			<img src="${item.url}">
		</td>
		<td> 종 류 : ${item.name}
	</tr>
	<tr>
		<td>가 격 : ${item.price}</td>
	</tr>
	<tr>
		<td>설 명 : ${item.description}</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><a href="itemList.do">상품 목록 보기</a></td>
	</tr>
</table>

<!-- <div id="count">
	<input type="button" value="장바구니 확인" style="float:right; margin-left:10px;">
	<input type="button" value="장바구니 담기" style="float:right;">
	<b>조회수 : ${item.count}</b>
</div>

<img alt="" src="${item.url}" id="image">

<div id="details">
	<br/><br/>
	종 류 : ${item.name}<br/><br/><br/><br/>
	가 격 : ${item.price}<br/><br/><br/><br/><br/><br/>
	설 명 : ${item.description}<br/><br/>
</div>
<div id="return" align="center">
	<a href="itemList.do">상품 목록 보기</a>
</div> -->
</body>
</html>