<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Upload File Successful!!</b><p>
<ul>
	<li>File Download &nbsp; &nbsp; &nbsp;</li>
	<a href="fileDown.do?filename=${uploadfile}">${uploadfile}</a>
</ul>
</body>
</html>