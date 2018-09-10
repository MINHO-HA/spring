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
	

	<%-- <c:choose>
		<c:when test="${not empty myPageCheck }">

			<ul>
				<li><a href="personalInfo?id=${sessionScope.session_id }">개인정보
						수정</a></li>
				<li><a href="reviewsIWrote">내가 쓴 리뷰</a></li>
				<li><a href="reviewsILiked">좋아요 한 리뷰</a></li>
				<li><a href="itemsIMarked">제품 찜 목록</a></li>
			</ul>
			<br>
		</c:when>


		<c:otherwise>
			비밀번호를 다시 한 번 입력해주세요.
			<form action="passwordForCheck?MEM_ID=${sessionScope.session_id }" method="post">
				<input type="password" name="MEM_PW"> <input type="submit"
					value="확인">
			</form>
		</c:otherwise>
	</c:choose> --%>
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
		<input type="password" name="MEM_PW" placeholder="비밀번호 입력" required="required"> <input type="submit"
			value="확인">
	</form>

</body>


</html>