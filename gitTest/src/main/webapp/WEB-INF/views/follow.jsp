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
<h1>팔로우 페이지</h1>
<hr>
	<a href="./">LOGO</a>
	<c:choose>
		<c:when test="${not empty sessionScope.session_id }">
			<c:choose>

				<c:when test="${sessionScope.session_id eq 'admin'}">
					<div style="float: right;">관리자님 환영합니다.</div>
				</c:when>
				<c:otherwise>
					<div style="float: right;">
						<a href="myPage">${sessionScope.session_id }</a> 님 환영해요
					</div>
				</c:otherwise>
			</c:choose>
			<br>
			<div style="float: right;">
				<input type="button" value="로그아웃" onclick="location.href='./logout'">
			</div>
		</c:when>
	</c:choose>
	<br>
	<br>
	<c:forEach var="followReview" items="${followReview }">
		<table>
			<tr>
				<td>
					리뷰 번호
				</td>
				<td>
					리뷰 제목
				</td>
				<td>
					좋아요 수
				</td>
				<td>
					내가 준 별점
				</td>
			</tr>
			<tr>
				<td>
					${followReview.REVIEW_ID }
				</td>
				<td>
					${followReview.REVIEW_TITLE }
				</td>
				<td>
					${followReview.REVIEW_LIKE }
				</td>
				<td>
					${followReview.REVIEW_GRADE }
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>