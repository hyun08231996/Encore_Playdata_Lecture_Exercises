<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>게시판 목록</h2>
<c:if test="${not empty user }">
	<h4 style="color:red; font-weight:bold;">${user.name}님 로그인 되어있습니다. <a href="memberLogout.do">로그아웃</a></h4>
</c:if>
<c:choose>
	<c:when test="${empty list}">
		<h3>등록된 게시글이 없습니다...</h3>
	</c:when>
	<c:otherwise>
		<table border="2px">
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>내용</th><th>아이디</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.no}</td><td><a href="boardDetail.do?no=${board.no}">${board.title}</a></td><td>${board.contents}</td><td>${board.id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<br>
<c:if test="${not empty user }">
	<a href="boardInput.do">게시판 입력</a><br>
</c:if>
<a href="./index.jsp">홈으로</a>
</body>
</html>