<%@page import="com.encore.spring.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
User vo = (User)session.getAttribute("vo");
if(vo==null){ //로그인 안된 상태
%>
	<b><a href="login.html">로그인</a></b>
<%
}else{ //로그인 된 상태
	session.invalidate();
}
%>
<c:choose>
	<c:when test="${vo==null}">
	
	</c:when>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutpop(){
		alert("Signed out");
	}
</script>
</head>
<body onload="return logoutpop()">
	<h2 align="center">로그아웃 되셨습니다.</h2><br>
	<div align="center"><a href="login.html">로그인</a></div>
</html>