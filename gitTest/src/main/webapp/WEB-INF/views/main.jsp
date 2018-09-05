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
	<c:choose>
		<c:when test="${not empty sessionScope }">
			<c:choose>
				<c:when test="${sessionScope eq  'admin'}">
		관리자님 환영합니다.
		</c:when>
				<c:otherwise>
		<a href="myPage">${sessionScope.session_id }</a> 님 환영해요~(아이디 클릭시 마이페이지로 이동)
		</c:otherwise>
			</c:choose>
			<input type="button" value="로그아웃" onclick="location.href='./logout'">
		</c:when>
	</c:choose>

	<br>
	<br>
	<br>

	<a href="login">Login(로그인페이지 이동)</a> /
	<a href="signUp">Sign Up(회원가입페이지 이동)</a> /

	<br>
	<br>



	<img src="1.jpg">이미지 설명~~~~~
	<br>
	<br>

	<select name="category">
		<option value="brand">브랜드</option>
	</select>
	<form action="serach" method="get">
		<input type="text" value="검색어를 입력해 주세요" name="serachContent">
		<input type="submit" value="검색">
	</form>
</body>
</html>