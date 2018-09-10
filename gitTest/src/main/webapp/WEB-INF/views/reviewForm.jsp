<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</head>
<%
	request.getParameter("ITEM_ID");
%>
<body>
	<a href="./">logo(메인이동)</a>
	<br>
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
	<h2>리뷰작성 페이지</h2>
	<form action="writeReviewForm" method="POST">
		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<input type="hidden" name="ITEM_ID"
			value="<%=request.getParameter("ITEM_ID")%>"> 제목 : <input
			type="text" name="REVIEW_TITLE"><br> 글 내용 :<br>
		<textarea rows="50" cols="100" name="REVIEW_CONTENT">글 내용을 작성하세요</textarea>
		<br> 별점 : <select name="REVIEW_GRADE">
			<option value="1">1점</option>
			<option value="2">2점</option>
			<option value="3">3점</option>
			<option value="4">4점</option>
			<option value="5">5점</option>
		</select><br> <input type="submit" value="리뷰등록"> <input
			type="button" value="뒤로가기" onclick="goBack()">
	</form>
</body>
</html>