<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>게시판 상세정보</h2>
<c:if test="${not empty user }">
	<h4 style="color:red; font-weight:bold;">${user.name}님 로그인 되어있습니다. <a href="memberLogout.do">로그아웃</a></h4>
</c:if>
<br>
<h1>${vo.no} ${vo.title}</h1>
<h2>${vo.id}</h2>
<p>${vo.contents}</p>
<div>
	<c:choose>
		<c:when test="${not empty vo.filename}">
			<img src="upload/${vo.filename}" onerror="this.style.display='none'" width="300px" height="300px"><br>
			다운로드 : <a href="fileDown.do?filename=${vo.filename}">${vo.filename}</a>
		</c:when>
	</c:choose>
</div>
<br>
<a href="boardList.do">게시판 목록</a><br>
<c:if test="${not empty user }">
	<a href="boardInput.do">게시판 입력</a><br>
</c:if>
<a href="./index.jsp">홈으로</a>
</body>
</html>