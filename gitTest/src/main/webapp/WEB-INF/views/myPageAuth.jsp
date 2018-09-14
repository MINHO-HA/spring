<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
}
</style>
</head>
<body>
	<h1>마이 페이지</h1>

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
	</c:choose>
	<br>
	<br>

	${sessionScope.session_id }님의 마이 페이지

	<br>

	<ul>
		<li style="font-weight: bold;">개인정보 수정</li>
		<li>내가 쓴 리뷰</li>
		<li>좋아요 한 리뷰</li>
		<li>제품 찜 목록</li>
	</ul>
	<br> 비밀번호를 다시 한 번 입력해주세요.
	<form action="passwordForCheck?MEM_ID=${sessionScope.session_id }"
		method="post">
		<input type="password" name="MEM_PW" placeholder="비밀번호 입력" required="required"> 
		<input type="submit" value="확인">
	</form>
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
		</select> 
		<input type="text" placeholder="검색어 입력" name="ITEM_NAME"> 
		<input type="submit" value="검색">
	</form>
</body>


</html>