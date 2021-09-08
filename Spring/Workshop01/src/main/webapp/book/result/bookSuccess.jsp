<%@page import="com.encore.spring.domain.Book"%>
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
		width: 500px;
		height: 200px;
		border: 1px solid;
		margin: 0 auto;
	}
	#wrap1{
	   display: flex;
	   justify-content: center;
	   background: #ddd;
	   align-items: center;
	   height: 30px;
	}
</style>
</head>
<body>
<div id="wrap">
	<h2 align="center">결과 페이지</h2>
	<h3 align="center">${bvo.title} 책이 정상적으로 저장 되었습니다</h3><br>
	<div id="wrap1">
		<a href="Book.html">추가 등록</a>&nbsp;
		<a href="bookList.do">  도서목록</a>
	</div>
</div>
</body>
</html>