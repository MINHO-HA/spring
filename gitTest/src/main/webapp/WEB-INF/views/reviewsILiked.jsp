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
		<li style="font-weight: bold;">좋아요 한 리뷰</li>
		<li><a href="listsIMarked?MEM_ID=${sessionScope.session_id }">제품 찜 목록</a></li>
	</ul>
	<br>
<h2>내가 좋아요한 리뷰</h2>
	<c:forEach var="list" items="${list }">
		리뷰 번호 : ${list.REVIEW_ID }<br>
		리뷰 제목 : ${list.REVIEW_TITLE }<br>
		좋아요 수 : ${list.REVIEW_LIKE }<br>
		작성자 : ${list.MEM_ID }<br>
		<br>
		<br>
		<br>
	</c:forEach>
</body>
</html>