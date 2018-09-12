<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<a href="./">logo(메인이동)</a>
	<c:choose>
		<c:when test="${not empty sessionScope.session_id }">
			<c:choose>
				<c:when test="${sessionScope.session_id eq 'admin'}">
		관리자님 환영합니다.
		</c:when>
				<c:otherwise>
					<a href="myPage">${sessionScope.session_id }</a> 님 환영해요~(아이디 클릭시 마이페이지로 이동)
		</c:otherwise>
			</c:choose>
			<input type="button" value="로그아웃" onclick="location.href='./logout'">
		</c:when>
		<c:otherwise>
			<a href="loginPage">Login(로그인페이지 이동)</a> /
			<a href="signUp">Sign Up(회원가입페이지 이동)</a> /
		</c:otherwise>
	</c:choose>





	<br>
	<br>



	<img src="1.jpg">이미지 설명~~~~~
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="searchItem" method="get">
		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<select name="ITEM_CATEGORY">
			<option value="hair">헤어</option>
			<option value="skincare">스킨케어</option>
			<option value="cleansing">클렌징</option>
			<option value="perfume">향수</option>
		</select> <input type="text" placeholder="검색어 입력" name="ITEM_NAME"> <input
			type="submit" value="검색">

	</form>
</body>
</html>