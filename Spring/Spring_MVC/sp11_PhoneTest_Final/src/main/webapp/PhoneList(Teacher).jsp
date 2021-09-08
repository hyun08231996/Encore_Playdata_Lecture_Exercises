<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function (){
		$('#selectedDel').on('click',function(){
			let url = "delete.do?"
			$(":checkbox:checked").each(function(index,item){
				url += "num="+$(item).attr('data-num')+"&";
			});//each
			location.href=url
			
		});
		
		$('#selectedDel').on('click',function(){
			var param="";
			$(":checkbox:checked").each(function(index,item){
				param = param + "&num="+$(item).attr('data-num');
			});
			
			$.ajax({
				type:'get',
				url:'delete.do',
				data:param,
				
				success:function(data){
					location.reload();
				}
			})
			
		});
		
		
	});
	
</script>
<style type="text/css">
table, tr, th, td{
	border:1px solid lightgray;
	border-collapse:collapse;
	text-align:center;
}
th, td{
	width: 20%;
}
th{
	background-color:#E6ECDE;
}
td{
	background-color:white;
}
button{
	background-color:#E6ECDE;
	border:1px solid grey;
	border-radius:4px;
}
button:hover{
	cursor: pointer;
	background-color:#bacba4;
}
</style>
</head>
<body>	
	<jsp:include page="/header.jsp"/>
	<c:choose>
		<c:when test="${empty phones}">
			<h4 align="center">등록된 핸드폰이 없습니다...</h4>
		</c:when>
		<c:otherwise>
			<table align="center">
				<tr>
					<th>모델번호</th>
					<th>모델이름</th>
					<th>가격</th>
					<th>제조사명</th>
					<c:if test="${!empty loginUser}">
						<th>삭제</th>
					</c:if>
				</tr>		
				<c:forEach items="${phones}" var="phone">
					<tr class="phoneList">
						<td><a href="detail.do?num=${phone.num}" id="phoneNum">${phone.num}</a></td>
						<td>${phone.model}</td>
						<td>${phone.price}</td>
						<td>${phone.company.vendor}</td>
						<c:if test="${!empty loginUser}">
							<td><input type="checkbox" class="delete" name="delete" id="delete" data-num="${phone.num}"></td>
						</c:if>
					</tr>
				</c:forEach>
				<tr id="ajaxSuccess">
					
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	<br>
	<div align="center">
		<c:if test="${!empty loginUser}">
			<button onclick="location.href='regPhone.do'">추가 등록</button>&nbsp;
			<button id="selectedDel">선택항목삭제</button>
		</c:if>
	</div>
</body>
</html>