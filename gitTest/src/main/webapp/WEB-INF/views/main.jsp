<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="login">Login(로그인페이지 이동)</a> /
	<a href="signUp">Sign Up(회원가입페이지 이동)</a> / 
	<a href="myPage">myPage(마이페이지로 이동)</a>
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