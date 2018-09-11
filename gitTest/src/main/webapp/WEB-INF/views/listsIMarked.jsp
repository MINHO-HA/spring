<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul{
	list-style: none;	
}
</style>
</head>
<body>
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
	<br><br>
${sessionScope.session_id }님의
	마이 페이지

	<br>

	<ul>
		<li><a href="personalInfo?id=${sessionScope.session_id }">개인정보 수정</a></li>
		<li><a href="reviewsIWrote?MEM_ID=${sessionScope.session_id }">내가 쓴 리뷰</a></li>
		<li><a href="reviewsILiked?TARGET_MEM_ID=${sessionScope.session_id }">좋아요 한 리뷰</a></li>
		<li style="font-weight: bold;">제품 찜 목록</li>
	</ul>
	<br>
<h2>내가 찜한 목록</h2>
	<c:forEach var="list" items="${list }">
		카테고리 : ${list.ITEM_CATEGORY }<br>
		제품명 : ${list.ITEM_NAME }<br>
		<h1>별점(평균) : 평균값 넣어야된다!!!</h1><br>
		브랜드: ${list.ITEM_BRAND }<br>
		<br>
		<br>
		<br>
	</c:forEach>
</body>
</html>