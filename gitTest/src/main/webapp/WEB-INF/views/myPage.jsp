<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sessionScope.session_id }님의 마이 페이지
	<br>
	<ul>
		<li><a href="personalInfo?id=${sessionScope.session_id }">개인정보 수정</a></li>
		<li><a href="reviewsIWrote">내가 쓴 리뷰</a></li>
		<li><a href="reviewsILike">좋아요 한 리뷰</a></li>
		<li><a href="selectedLists">제품 찜 목록</a></li>
	</ul>
	<br>
	비밀번호를 다시 한 번 입력해주세요.
	<form action="passwordForCheck" method="get">
	<input type="password" name="password">
	<input type="submit" value="확인">
	</form>
</body>
</html>