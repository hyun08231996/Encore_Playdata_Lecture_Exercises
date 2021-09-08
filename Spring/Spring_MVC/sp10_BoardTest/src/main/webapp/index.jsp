<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Project</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<h1> 메인 페이지 </h1>
<p>
<c:choose>
	<c:when test="${not empty user }">
		<h4 style="color:red; font-weight:bold;">${user.name}님 ${msg} <a href="memberLogout.do">로그아웃</a></h4>
	</c:when>
	<c:otherwise>
		<h4 style="color:red; font-weight:bold;">${msg}</h4>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${empty user}">
		<jsp:include page="login.html"/>
		<h3> <a href="register.jsp">회원가입</a></h3>
		<h3> <a href="boardList.do">게시판 목록</a></h3>
	</c:when>
	<c:otherwise>
	    <h3> <a href="boardInput.do">게시판 입력</a></h3>
		<h3> <a href="boardList.do">게시판 목록</a></h3>
	</c:otherwise>
</c:choose>

</body>
</html>




