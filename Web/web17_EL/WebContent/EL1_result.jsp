<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩된 내용을 찾아온다..</h2>
<b>1~50까지의 합산 결과 1) :: </b><br>
<%= request.getAttribute("RESULT") %><br>
<%= session.getAttribute("RESULT") %>
<hr>
<b>1~50까지의 합산 결과 2) EL :: </b><br>
${RESULT}<br>
${requestScope.RESULT}<br>
${sessionScope.RESULT}
<hr>
${RESULT}<br>
${RESULT+10000}<br>
${NAME}<br>
</body>
</html>