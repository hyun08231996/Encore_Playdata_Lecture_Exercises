<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap{
	margin-left:400px;
	margin-right:400px;
}
</style>
</head>
<body>
<h2 align="center"><b>도서 목록 화면</b></h2>
<div id="wrap">
<form action="search.do">
	<div style="float:right;">
		<span>
		    <select name="searchCategory" id="searchCategory">
		        <option value='' selected>--선택--</option>
		        <option value='all'>전체</option>
		        <option value='isbn'>도서번호</option>
		        <option value='title'>도서명</option>
		        <option value='catalogue'>도서분류</option>
		        <option value='author'>저자</option>
		    </select>
		</span>
	<input type="text" name="search">
	<input type="submit" value="검색">
	</div>
</form><br>
<table border="1" width="720" align="center">
	<tr height="40px" align="center" bgcolor=" #ddd">
			<td width="25%">도서번호</td>
			<td width="45%">도서명</td>
			<td width="15%">도서분류</td>
			<td width="15%">저자</td>
	</tr>
	<c:choose>
		<c:when test="${empty book}">
			<c:forEach items="${list}" var="book">
				<tr height="40px">
					<td width="25%">${book.isbn}</td>
					<td width="45%"><a href="${pageContext.request.contextPath}/front.do?command=view&isbn=${book.isbn}">${book.title}</a></td>
					<td width="15%">${book.catalogue}</td>
					<td width="15%">${book.author}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr height="40px">
				<td width="25%">${book.isbn}</td>
				<td width="45%"><a href="${pageContext.request.contextPath}/front.do?command=view&isbn=${book.isbn}">${book.title}</a></td>
				<td width="15%">${book.catalogue}</td>
				<td width="15%">${book.author}</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table><br>
<div align="center"><a href="Book.html">도서 등록</a></div>
</div>
</body>
</html>