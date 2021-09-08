<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Product List</h1>
<table align="center">
	<tr align="center">
		<td>제품 Id</td><td>제품명</td><td>제조사</td><td>가격</td>
	</tr>
	<c:forEach items="${nameList}" var="product">
		<tr align="center">
			<td>${product.id}</td><td>${product.name}</td><td>${product.maker}</td><td>${product.price}</td>
		<tr>
	</c:forEach>
</table>
</body>
</html>