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
<b>Multi File Upload OK~~~!!</b><p>
<ul>
	<c:forEach items="${uploadfiles}" var="filename">
		<li>Upload File :: <a href="fileDown.do?filename=${filename}">${filename}</a></li><br>
	</c:forEach>
</ul>
</body>
</html>