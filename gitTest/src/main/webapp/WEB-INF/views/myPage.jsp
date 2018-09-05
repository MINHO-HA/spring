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

	${sessionScope.session_id }님의 마이 페이지

	<br>

	<c:choose>
		<c:when test="${not empty check }">

			<ul>
				<li><a href="personalInfo?id=${sessionScope.session_id }">개인정보
						수정</a></li>
				<li><a href="reviewsIWrote">내가 쓴 리뷰</a></li>
				<li><a href="reviewsILike">좋아요 한 리뷰</a></li>
				<li><a href="selectedLists">제품 찜 목록</a></li>
			</ul>
			<br>
		</c:when>


		<c:otherwise>
			비밀번호를 다시 한 번 입력해주세요.
			<form action="passwordForCheck?MEM_ID=${sessionScope.session_id }"
				method="post">
				<input type="password" name="MEM_PW"> <input type="submit"
					value="확인">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>