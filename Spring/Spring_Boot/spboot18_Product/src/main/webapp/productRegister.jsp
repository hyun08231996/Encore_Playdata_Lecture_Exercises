<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Product Register Form....</h2>
<form action="myProduct.do" method="post">
상품명 : <input type="text" name="name"><br><br>
제조사 : <input type="text" name="maker"><br><br>
가 격 : <input type="text" name="price"><br><br>
<input type="submit" value="상품등록">
</form>
++++++++++++++++++++++++++++++++++++++++++++++++++
<form action="mySearch.do">
	<h3>상품검색</h3> 
	<select name='choice'>
		<option value='' selected>-- 선택 --</option>\
		<option value='id'>ID</option>
		<option value='maker'>제조사</option>
 		<option value='name'>상품명</option>
	</select>
	<input type="text" name="word"><br>
	
	<br> <input type="submit" value="상품찾기" name="search"><br>
</form>
<!-- <form action="idSearch.do" method="post">
Id검색 : <input type="text" name="id"><br><br>
<input type="submit" value="상품찾기">
</form>
++++++++++++++++++++++++++++++++++++++++++++++++++
<form action="nameSearch.do" method="post">
상품명검색 : <input type="text" name="name"><br><br>
<input type="submit" value="상품찾기">
</form>
++++++++++++++++++++++++++++++++++++++++++++++++++
<form action="makerSearch.do" method="post">
제조사검색 : <input type="text" name="maker"><br><br>
<input type="submit" value="상품찾기">
</form> -->
++++++++++++++++++++++++++++++++++++++++++++++++++
<form action="myProductUpdate.do" method="post">
<h3>업데이트할 제품 ID</h3> 
Id : <input type="text" name="id"><br><br>
상품명 : <input type="text" name="name"><br><br>
제조사 : <input type="text" name="maker"><br><br>
가 격 : <input type="text" name="price"><br><br>
<input type="submit" value="상품변경">
</form>
++++++++++++++++++++++++++++++++++++++++++++++++++
<form action="myProductDelete.do" method="post">
<h3>삭제할 제품 ID</h3> 
Id : <input type="text" name="id"><br><br>
<input type="submit" value="상품삭제">
</form>
</body>
</html>