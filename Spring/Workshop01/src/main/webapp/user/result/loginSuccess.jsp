<%@page import="com.encore.spring.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap{ 
	text-align:center;
	width: 530px;
	height: 230px;
	border: 1px solid;
	margin: 0 auto;
}
</style>
</head>
<body>
<div id="wrap">
	<h2 align="center">${vo.userId}님이 로그인 되었습니다!!</h2><br>
	<h3 align="center"><a href="Book.html">도서 등록</a></h3>
	<h3 align="center"><a href="bookList.do">도서 목록</a></h3>
	<h3 align="center"><a href="logout.jsp">로그아웃</a></h3>
</div>
</body>
</html>