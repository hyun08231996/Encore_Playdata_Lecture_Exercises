<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/basic.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
	function formReset(){
		boardForm.reset();
		boardForm.title.focus();
	}
</script>
<style type="text/css">
	table {
	  border-collapse:separate; 
	  border-spacing: 0 1em;
	}
	.button{
	  padding:4px 10px;
	  background-color:#808080;
	  color:white;
	  border-radius: 4px;
	  border:none;
	}
</style>
</head>
<body>
<h2>게시글 작성</h2>
<c:if test="${not empty user}">
	<h4 style="color:red; font-weight:bold;">${user.name}님 로그인 되어있습니다. <a href="memberLogout.do">로그아웃</a></h4>
</c:if>
	<form method="post"
		action="boardInsert.do"
		enctype="multipart/form-data"
		name="boardForm"
		id="boardForm">
		<table>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" id="title">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" id="id">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="contents" id="contents" ROWS="10" COLS="30"></textarea>
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" name="uploadFile" id="uploadFile">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" class="button" value="작성">&nbsp;
					<input type="button" class="button" value="취소" onclick="return formReset()">
				</td>
			</tr>
		</table>
		
	</form>
<br>
<a href="boardList.do">게시판 목록</a><br>
<a href="./index.jsp">홈으로</a>
</body>
</html>