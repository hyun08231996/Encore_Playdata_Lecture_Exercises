<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"><b>Change Member Information</b></h2><p>
<form action="front.do" method="post">
<input type="hidden" name="command" value="update">
	
	ID : <input type="text" name="id" value="${vo.id}" readonly="readonly"><br>
	PASSWORD : <input type="password" name="password" value="${vo.password}"><br>
	NAME : <input type="text" name="name" value="${vo.name}"><br>
	ADDRESS : <input type="text" name="address" value="${vo.address}"><br>
	
	<input type="submit" value="Change">
	
</form>
</body>
</html>