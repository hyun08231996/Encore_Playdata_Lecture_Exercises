<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{
		text-align: center;
		border: 2px dotted green;
	}
</style>
</head>
<body>
<h1>CafeMember :: FactoryMethodPattern + EL, JSTL + AJAX </h1>
<%--
jstl -- choose
           when
           
           otherwise
index페이지에서는 클라이언트가 6가지의 서비스를 요청할수 있다.
이때 인증과 권한에 따라서 요청할 수 있는 서비스가 달라져야 한다.

authentification(인증)
				 회원 검색 하기
로그인 한 사용자 -  권한(authorization)
   	             로그아웃 / 전체회원정보보기 / 정보수정

로그인 안한 사용자 - 권한(authentification)
				  회원가입 / 로그인
 --%>
 <!-- 
 	1. 아이디로 회원 검색하기 클릭하면
 	2. IdListController :: member테이블의 모든 아이디 리스트를 받아온다.
 							바인딩
 							show_idList.jsp
 	3. show_idList.jsp :: 특정한 아이디를 select<option 에서 선택하는 순간 이벤트 발생
 							비동기 코드 작성.
 							특정한 아이디 옆에 응답정보(해당하는) 이름, 주소 정보가 출력되도록 작성
 
 
  -->
<div id="wrap">	
	<!-- <a href="find.jsp">회원 검색 하기</a><p> -->
	<a href="idList.do">아이디로 회원 검색 하기</a><p>
	<c:choose>
		<c:when test="${!empty vo}">
			<a href="allmember.do">모든 회원 보기</a><p>	
			<a href=update.jsp>회원 정보 수정</a><p>
			<a href="logout.do">로그아웃</a><p>		
		</c:when>
		<c:otherwise>
			<a href="register.jsp">회원 가입 하기</a><p>	
			<a href="login.jsp">로그인 하기</a><p>		
		</c:otherwise>	
	</c:choose>
</div>
</body>
</html>






