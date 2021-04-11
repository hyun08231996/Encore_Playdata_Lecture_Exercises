<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<B>1. JSP 기본 엘러먼트로 폼값 받아오기</B><br>
ID <%= request.getParameter("userId") %>
<hr>
<B>2. EL로 폼값 받아오기</B><br>
ID ${param.userId}

<br><hr><br>
<B>1. JSP 기본 엘러먼트로 Checkbox 폼값 받아오기</B><br>
<%
String[ ] menus = request.getParameterValues("menu");
for(String menu : menus){
%>
	<%= menu %>
<%
}
%>
<hr>
<B>2. EL로 Checkbox 폼값 받아오기</B><br>
선택한 메뉴 ::<br>
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}

</body>
</html>