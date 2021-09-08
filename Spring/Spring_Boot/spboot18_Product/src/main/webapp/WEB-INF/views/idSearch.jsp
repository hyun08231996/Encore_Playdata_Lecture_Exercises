<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1px solid black">
	<tr align="center">
		<td>제품 Id</td><td>제품명</td><td>제조사</td><td>가격</td>
	</tr>
	<tr align="center">
		<td>${product.id}</td><td>${product.name}</td><td>${product.maker}</td><td>${product.price}</td>
	<tr>
</table>
</body>
</html>